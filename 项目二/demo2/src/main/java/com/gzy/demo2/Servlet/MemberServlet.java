package com.gzy.demo2.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.gzy.demo2.entity.Member;
import com.gzy.demo2.entity.Society;
import com.gzy.demo2.mapper.MemberMapper;
import com.gzy.demo2.mapper.SocietyMapper;
import com.gzy.demo2.util.MyBatisUtil;

@WebServlet(name = "memberServlet", value = "/member")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前登录用户信息
        HttpSession session = request.getSession();
        com.gzy.demo2.entity.Student student = (com.gzy.demo2.entity.Student) session.getAttribute("student");
        
        // 如果用户未登录，跳转到登录页面
        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        // 设置学生姓名，用于页面显示
        request.setAttribute("studentName", student.getStudentName());
        
        // 获取操作类型
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        
        SqlSession sqlSession = null;
        try {
            // 使用MyBatis查询数据
            sqlSession = MyBatisUtil.getSqlSession();
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            
            // 获取当前登录用户的成员信息，包括职位
            Integer currentUserId = student.getStudentId();
            
            // 调试信息：输出当前登录学生的完整信息
            System.out.println("当前登录学生信息：");
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Student Number: " + student.getStudentNumber());
            System.out.println("Student Name: " + student.getStudentName());
            
            // 获取当前用户在所有协会中的职位，判断是否是会长或副会长
            boolean isPresidentOrVice = false;
            
            // 首先检查用户是否有会员记录
            List<Member> userMemberships = memberMapper.selectMembersByStudentId(currentUserId);
            
            // 调试信息：输出当前用户的所有会员记录
            System.out.println("当前用户ID: " + currentUserId);
            System.out.println("会员记录数量: " + userMemberships.size());
            
            // 遍历所有会员记录，判断是否是会长或副会长
            for (Member membership : userMemberships) {
                System.out.println("会员ID: " + membership.getMemberId() + ", 协会ID: " + membership.getMemberSocietyId() + ", 职位: " + membership.getMemberPosition() + ", 状态: " + membership.getMemberStatus());
                
                // 只要在任何一个协会中是会长或副会长，就显示申请列表
                if (membership.getMemberPosition() == 1 || membership.getMemberPosition() == 2) {
                    isPresidentOrVice = true;
                    System.out.println("设置isPresidentOrVice为true，因为在协会" + membership.getMemberSocietyId() + "中是" + (membership.getMemberPosition() == 1 ? "会长" : "副会长"));
                    break;
                }
            }
            
            // 特殊处理：如果用户没有任何会员记录，但学号是20250901（假设是默认会长账号），也显示申请列表
            if (!isPresidentOrVice && student.getStudentNumber() == 20250901) {
                isPresidentOrVice = true;
                System.out.println("学号是20250901，特殊处理设置isPresidentOrVice为true");
            }
            
            // 将职位信息设置到request中，用于页面判断
            request.setAttribute("isPresidentOrVice", isPresidentOrVice);
            
            // 调试信息：输出最终的isPresidentOrVice值
            System.out.println("最终isPresidentOrVice值: " + isPresidentOrVice);
            
            switch (action) {
                case "list":
                    // 获取搜索关键词
                    String keyword = request.getParameter("keyword");
                    
                    // 查询所有协会
                    SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
                    List<Society> societies = societyMapper.selectAllSocieties();
                    
                    // 如果有搜索关键词，查询匹配的会员
                    if (keyword != null && !keyword.trim().isEmpty()) {
                        List<Member> searchResults = memberMapper.selectMembersByKeyword(keyword);
                        request.setAttribute("searchResults", searchResults);
                        request.setAttribute("keyword", keyword);
                    }
                    
                    request.setAttribute("societies", societies);
                    request.getRequestDispatcher("member/list.jsp").forward(request, response);
                    break;
                case "societyMembers":
                    // 查询协会的所有成员
                    SocietyMapper societyMapper2 = sqlSession.getMapper(SocietyMapper.class);
                    Integer societyId = Integer.parseInt(request.getParameter("societyId"));
                    List<Member> societyMembers = memberMapper.selectMembersBySocietyId(societyId);
                    Society society = societyMapper2.selectSocietyById(societyId);

                    // 根据当前协会ID和学生ID查询currentMember
                    Member currentMember = null;
                    for (Member member : societyMembers) {
                        if (member.getMemberStudentId().equals(currentUserId)) {
                            currentMember = member;
                            break;
                        }
                    }
                    request.setAttribute("currentMember", currentMember);
                    request.setAttribute("members", societyMembers);
                    request.setAttribute("society", society);
                    request.getRequestDispatcher("member/society_members.jsp").forward(request, response);
                    break;
                case "applyJoin":
                    // 申请加入协会
                    Integer applySocietyId = Integer.parseInt(request.getParameter("societyId"));
                    
                    // 检查用户是否已经加入该社团或正在申请加入
                    boolean alreadyJoined = false;
                    // 获取当前用户在该社团的所有记录，不管状态如何
                    List<Member> existingMembers = memberMapper.selectMembersBySocietyId(applySocietyId);
                    for (Member member : existingMembers) {
                        if (member.getMemberStudentId().equals(currentUserId)) {
                            alreadyJoined = true;
                            break;
                        }
                    }
                    
                    // 额外检查：如果用户之前退出过该社团，也不允许重新申请
                    List<Member> allMembers = memberMapper.selectAllMembers();
                    for (Member member : allMembers) {
                        if (member.getMemberStudentId().equals(currentUserId) && 
                            member.getMemberSocietyId().equals(applySocietyId) && 
                            member.getMemberStatus() == 2) {
                            alreadyJoined = true;
                            break;
                        }
                    }
                    
                    if (alreadyJoined) {
                        // 已经加入该社团，弹窗提示
                        request.setAttribute("alertMessage", "你已经加入该社团");
                        
                        // 查询所有协会
                        SocietyMapper societyMapperForList = sqlSession.getMapper(SocietyMapper.class);
                        List<Society> societiesForList = societyMapperForList.selectAllSocieties();
                        request.setAttribute("societies", societiesForList);
                        
                        request.getRequestDispatcher("member/list.jsp").forward(request, response);
                    } else {
                        // 未加入该社团，提交申请
                        Member newMember = new Member();
                        newMember.setMemberStudentId(currentUserId);
                        newMember.setMemberSocietyId(applySocietyId);
                        newMember.setJoinDate(java.time.LocalDate.now());
                        newMember.setMemberStatus(4); // 4表示申请加入
                        newMember.setMemberPosition(3); // 3表示普通成员
                        memberMapper.insertMember(newMember);
                        sqlSession.commit();
                        
                        // 弹窗提示
                        request.setAttribute("alertMessage", "申请已经提交，等待审核");
                        
                        // 查询所有协会
                        SocietyMapper societyMapperForList = sqlSession.getMapper(SocietyMapper.class);
                        List<Society> societiesForList = societyMapperForList.selectAllSocieties();
                        request.setAttribute("societies", societiesForList);
                        
                        request.getRequestDispatcher("member/list.jsp").forward(request, response);
                    }
                    break;
                case "joinApplicationList":
                    // 获取当前用户管理的协会ID
                    List<Member> userMembershipsJoin = memberMapper.selectMembersByStudentId(currentUserId);
                    List<Integer> managedSocietyIds = new ArrayList<>();
                    for (Member membership : userMembershipsJoin) {
                        if (membership.getMemberPosition() == 1 || membership.getMemberPosition() == 2) {
                            managedSocietyIds.add(membership.getMemberSocietyId());
                        }
                    }
                    
                    // 查询当前用户管理的协会中的加入申请（状态为4）
                    List<Member> joinApplications = new ArrayList<>();
                    if (!managedSocietyIds.isEmpty()) {
                        // 遍历所有管理的协会，查询加入申请
                        for (Integer societyIdJoin : managedSocietyIds) {
                            List<Member> societyJoinApps = memberMapper.selectMembersBySocietyIdAndStatus(societyIdJoin, 4);
                            joinApplications.addAll(societyJoinApps);
                        }
                    }
                    
                    // 传递消息提示参数
                    request.setAttribute("message", request.getParameter("message"));
                    request.setAttribute("messageType", request.getParameter("messageType"));
                    
                    request.setAttribute("joinApplications", joinApplications);
                    request.setAttribute("isPresidentOrVice", !managedSocietyIds.isEmpty());
                    request.setAttribute("studentName", student.getStudentName());
                    
                    request.getRequestDispatcher("member/join_application_list.jsp").forward(request, response);
                    break;
                case "quitApplicationList":
                    // 获取当前用户管理的协会ID
                    List<Member> userMembershipsQuit = memberMapper.selectMembersByStudentId(currentUserId);
                    List<Integer> managedSocietyIdsQuit = new ArrayList<>();
                    for (Member membership : userMembershipsQuit) {
                        if (membership.getMemberPosition() == 1 || membership.getMemberPosition() == 2) {
                            managedSocietyIdsQuit.add(membership.getMemberSocietyId());
                        }
                    }
                    
                    // 查询当前用户管理的协会中的退出申请（状态为3）
                    List<Member> quitApplications = new ArrayList<>();
                    if (!managedSocietyIdsQuit.isEmpty()) {
                        // 遍历所有管理的协会，查询退出申请
                        for (Integer societyIdQuit : managedSocietyIdsQuit) {
                            List<Member> societyQuitApps = memberMapper.selectMembersBySocietyIdAndStatus(societyIdQuit, 3);
                            quitApplications.addAll(societyQuitApps);
                        }
                    }
                    
                    // 传递消息提示参数
                    request.setAttribute("message", request.getParameter("message"));
                    request.setAttribute("messageType", request.getParameter("messageType"));
                    
                    request.setAttribute("quitApplications", quitApplications);
                    request.setAttribute("isPresidentOrVice", !managedSocietyIdsQuit.isEmpty());
                    request.setAttribute("studentName", student.getStudentName());
                    
                    request.getRequestDispatcher("member/quit_application_list.jsp").forward(request, response);
                    break;
                case "approveJoin":
                    // 同意加入申请
                    String approveJoinId = request.getParameter("id");
                    if (approveJoinId != null) {
                        Integer memberId = Integer.parseInt(approveJoinId);
                        memberMapper.updateMemberStatus(memberId, 1); // 1表示已加入
                        sqlSession.commit();
                        response.sendRedirect(request.getContextPath() + "/member?action=joinApplicationList&message=已同意加入申请&messageType=success");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/member?action=joinApplicationList&message=无效的申请ID&messageType=error");
                    }
                    break;
                case "rejectJoin":
                    // 拒绝加入申请
                    String rejectJoinId = request.getParameter("id");
                    if (rejectJoinId != null) {
                        Integer memberId = Integer.parseInt(rejectJoinId);
                        memberMapper.deleteMemberById(memberId); // 删除申请记录
                        sqlSession.commit();
                        response.sendRedirect(request.getContextPath() + "/member?action=joinApplicationList&message=已拒绝加入申请&messageType=success");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/member?action=joinApplicationList&message=无效的申请ID&messageType=error");
                    }
                    break;
                case "approveQuit":
                    // 同意退出申请 - 删除成员记录
                    String approveQuitId = request.getParameter("id");
                    if (approveQuitId != null) {
                        Integer memberId = Integer.parseInt(approveQuitId);
                        memberMapper.deleteMemberById(memberId); // 直接删除成员记录
                        sqlSession.commit();
                        response.sendRedirect(request.getContextPath() + "/member?action=list&message=已同意退出申请&messageType=success");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/member?action=list&message=无效的申请ID&messageType=error");
                    }
                    break;
                case "rejectQuit":
                    // 拒绝退出申请 - 保持成员信息，恢复为正常状态
                    String rejectQuitId = request.getParameter("id");
                    if (rejectQuitId != null) {
                        Integer memberId = Integer.parseInt(rejectQuitId);
                        memberMapper.updateMemberStatus(memberId, 1); // 1表示已加入（恢复正常状态）
                        sqlSession.commit();
                        response.sendRedirect(request.getContextPath() + "/member?action=list&message=已拒绝退出申请&messageType=success");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/member?action=list&message=无效的申请ID&messageType=error");
                    }
                    break;
                case "applyQuit":
                    // 申请退出协会
                    String applyQuitId = request.getParameter("id");
                    if (applyQuitId != null) {
                        Integer memberId = Integer.parseInt(applyQuitId);
                        memberMapper.updateMemberStatus(memberId, 3); // 3表示申请退出
                        response.sendRedirect("member?action=societyMembers&societyId=" + request.getParameter("societyId"));
                    }
                    break;
                case "detail":
                    // 查询成员详情
                    String idStr = request.getParameter("id");
                    if (idStr != null) {
                        Integer memberId = Integer.parseInt(idStr);
                        Member member = memberMapper.selectMemberById(memberId);
                        request.setAttribute("member", member);
                        request.getRequestDispatcher("member/detail.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("member?action=list");
                    }
                    break;
                case "create":
                    // 跳转到创建成员页面
                    request.getRequestDispatcher("member/create.jsp").forward(request, response);
                    break;
                case "edit":
                    // 查询成员信息，跳转到编辑页面
                    String editIdStr = request.getParameter("id");
                    if (editIdStr != null) {
                        Integer memberId = Integer.parseInt(editIdStr);
                        Member member = memberMapper.selectMemberById(memberId);
                        request.setAttribute("member", member);
                        request.getRequestDispatcher("member/edit.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("member?action=list");
                    }
                    break;
                default:
                    // 默认跳转到成员列表页面
                    List<Member> defaultMembers = memberMapper.selectAllMembers();
                    request.setAttribute("members", defaultMembers);
                    request.getRequestDispatcher("member/list.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 处理异常，跳转到错误页面或者返回错误信息
            request.setAttribute("error", "服务器内部错误：" + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } finally {
            // 关闭数据库连接
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前登录用户信息
        HttpSession session = request.getSession();
        com.gzy.demo2.entity.Student student = (com.gzy.demo2.entity.Student) session.getAttribute("student");
        
        // 如果用户未登录，跳转到登录页面
        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        // 设置学生姓名，用于页面显示
        request.setAttribute("studentName", student.getStudentName());
        
        // 获取操作类型
        String action = request.getParameter("action");
        
        SqlSession sqlSession = null;
        try {
            // 使用MyBatis操作数据库
            sqlSession = MyBatisUtil.getSqlSession();
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            
            switch (action) {
                case "create":
                    // 创建成员
                    // 这里需要获取表单数据，然后插入数据库
                    response.sendRedirect("member?action=list");
                    break;
                case "edit":
                    // 编辑成员
                    // 这里需要获取表单数据，然后更新数据库
                    response.sendRedirect("member?action=list");
                    break;
                case "delete":
                    // 删除成员
                    String deleteIdStr = request.getParameter("id");
                    if (deleteIdStr != null) {
                        Integer memberId = Integer.parseInt(deleteIdStr);
                        memberMapper.deleteMemberById(memberId);
                        sqlSession.commit();
                    }
                    response.sendRedirect("member?action=list");
                    break;
                case "applyQuit":
                    // 申请退出（普通成员）
                    String applyQuitIdStr = request.getParameter("id");
                    String societyIdStr = request.getParameter("societyId");
                    if (applyQuitIdStr != null && societyIdStr != null) {
                        Integer memberId = Integer.parseInt(applyQuitIdStr);
                        Integer societyId = Integer.parseInt(societyIdStr);
                        // 将成员状态设置为申请退出（3）
                        memberMapper.updateMemberStatus(memberId, 3);
                        sqlSession.commit();
                        
                        // 弹窗提示
                        request.setAttribute("alertMessage", "申请已经提交");
                        
                        // 查询协会的所有成员，返回到协会成员页面
                        SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
                        List<Member> societyMembers = memberMapper.selectMembersBySocietyId(societyId);
                        Society society = societyMapper.selectSocietyById(societyId);
                        
                        // 获取当前登录用户的成员信息，包括职位
                        Integer currentUserId = student.getStudentId();
                        Member currentMember = null;
                        for (Member member : societyMembers) {
                            if (member.getMemberStudentId().equals(currentUserId)) {
                                currentMember = member;
                                break;
                            }
                        }
                        request.setAttribute("currentMember", currentMember);
                        request.setAttribute("members", societyMembers);
                        request.setAttribute("society", society);
                        
                        request.getRequestDispatcher("member/society_members.jsp").forward(request, response);
                    } else {
                        // 如果没有提供必要的参数，返回协会列表
                        SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
                        List<Society> societies = societyMapper.selectAllSocieties();
                        request.setAttribute("societies", societies);
                        request.getRequestDispatcher("member/list.jsp").forward(request, response);
                    }
                    break;
                case "approveQuit":
                    // 审批退出（会长或副会长）- 删除成员记录
                    String approveQuitIdStr = request.getParameter("id");
                    if (approveQuitIdStr != null) {
                        Integer memberId = Integer.parseInt(approveQuitIdStr);
                        // 直接删除成员记录
                        memberMapper.deleteMemberById(memberId);
                        sqlSession.commit();
                        response.sendRedirect(request.getContextPath() + "/member?action=list&message=已同意退出申请&messageType=success");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/member?action=list&message=无效的申请ID&messageType=error");
                    }
                    break;
                case "rejectQuit":
                    // 拒绝退出（会长或副会长）
                    String rejectQuitIdStr = request.getParameter("id");
                    if (rejectQuitIdStr != null) {
                        Integer memberId = Integer.parseInt(rejectQuitIdStr);
                        // 将成员状态设置为正常（1）
                        memberMapper.updateMemberStatus(memberId, 1);
                        sqlSession.commit();
                        response.sendRedirect(request.getContextPath() + "/member?action=list&message=已拒绝退出申请&messageType=success");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/member?action=list&message=无效的申请ID&messageType=error");
                    }
                    break;
                case "approveJoin":
                    // 审批加入（会长或副会长）
                    String approveJoinIdStr = request.getParameter("id");
                    if (approveJoinIdStr != null) {
                        Integer memberId = Integer.parseInt(approveJoinIdStr);
                        // 将成员状态设置为正常（1）
                        memberMapper.updateMemberStatus(memberId, 1);
                        sqlSession.commit();
                        response.sendRedirect(request.getContextPath() + "/member?action=joinApplicationList&message=已同意加入申请&messageType=success");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/member?action=joinApplicationList&message=无效的申请ID&messageType=error");
                    }
                    break;
                case "rejectJoin":
                    // 拒绝加入（会长或副会长）
                    String rejectJoinIdStr = request.getParameter("id");
                    if (rejectJoinIdStr != null) {
                        Integer memberId = Integer.parseInt(rejectJoinIdStr);
                        // 删除该成员记录
                        memberMapper.deleteMemberById(memberId);
                        sqlSession.commit();
                        response.sendRedirect(request.getContextPath() + "/member?action=joinApplicationList&message=已拒绝加入申请&messageType=success");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/member?action=joinApplicationList&message=无效的申请ID&messageType=error");
                    }
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/member?action=list");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 处理异常，跳转到错误页面或者返回错误信息
            request.setAttribute("error", "服务器内部错误：" + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } finally {
            // 关闭数据库连接
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}