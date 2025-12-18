package com.gzy.demo2.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.gzy.demo2.entity.Member;
import com.gzy.demo2.mapper.MemberMapper;
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
            
            switch (action) {
                case "list":
                    // 查询所有成员
                    List<Member> allMembers = memberMapper.selectAllMembers();
                    request.setAttribute("members", allMembers);
                    request.getRequestDispatcher("member/list.jsp").forward(request, response);
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
                default:
                    response.sendRedirect("member?action=list");
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