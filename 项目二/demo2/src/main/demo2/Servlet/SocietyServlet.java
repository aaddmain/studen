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

import com.gzy.demo2.entity.Society;
import com.gzy.demo2.mapper.SocietyMapper;
import com.gzy.demo2.util.MyBatisUtil;

@WebServlet(name = "societyServlet", value = "/society")
public class SocietyServlet extends HttpServlet {
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
            SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
            
            switch (action) {
                case "list":
                    // 获取搜索关键词
                    String keyword = request.getParameter("keyword");
                    List<Society> societies;
                    if (keyword != null && !keyword.trim().isEmpty()) {
                        // 搜索协会
                        societies = societyMapper.selectSocietiesByName(keyword);
                    } else {
                        // 查询所有协会
                        societies = societyMapper.selectAllSocieties();
                    }
                    request.setAttribute("societies", societies);
                    request.getRequestDispatcher("society/list.jsp").forward(request, response);
                    break;
                case "detail":
                    // 查询协会详情
                    String idStr = request.getParameter("id");
                    if (idStr != null) {
                        Integer societyId = Integer.parseInt(idStr);
                        Society society = societyMapper.selectSocietyById(societyId);
                        request.setAttribute("society", society);
                        request.getRequestDispatcher("society/detail.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("society?action=list");
                    }
                    break;
                case "create":
                    // 跳转到创建协会页面
                    request.getRequestDispatcher("society/create.jsp").forward(request, response);
                    break;
                case "edit":
                    // 查询协会信息，跳转到编辑页面
                    String editIdStr = request.getParameter("id");
                    if (editIdStr != null) {
                        Integer societyId = Integer.parseInt(editIdStr);
                        Society society = societyMapper.selectSocietyById(societyId);
                        request.setAttribute("society", society);
                        request.getRequestDispatcher("society/edit.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("society?action=list");
                    }
                    break;
                default:
                    // 默认跳转到协会列表
                    List<Society> defaultSocieties = societyMapper.selectAllSocieties();
                    request.setAttribute("societies", defaultSocieties);
                    request.getRequestDispatcher("society/list.jsp").forward(request, response);
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
            SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
            
            switch (action) {
                case "create":
                    // 创建协会
                    // 获取表单数据
                    String societyName = request.getParameter("societyName");
                    String societyCreatorStr = request.getParameter("societyCreator");
                    String societyIntro = request.getParameter("societyIntro");
                    String societyStatusStr = request.getParameter("societyStatus");
                    
                    // 创建协会对象
                    Society society = new Society();
                    society.setSocietyName(societyName);
                    society.setSocietyCreator(Integer.parseInt(societyCreatorStr));
                    society.setSocietyIntro(societyIntro);
                    society.setSocietyStatus(Integer.parseInt(societyStatusStr));
                    society.setSocietyCreateDate(java.time.LocalDate.now());
                    
                    // 插入数据库
                    societyMapper.insertSociety(society);
                    sqlSession.commit();
                    response.sendRedirect("society?action=list");
                    break;
                case "edit":
                    // 编辑协会
                    // 获取表单数据
                    String editIdStr = request.getParameter("id");
                    String editSocietyName = request.getParameter("societyName");
                    String editSocietyCreatorStr = request.getParameter("societyCreator");
                    String editSocietyIntro = request.getParameter("societyIntro");
                    String editSocietyStatusStr = request.getParameter("societyStatus");
                    
                    if (editIdStr != null) {
                        // 先查询原协会信息，保留创建日期
                        Integer societyId = Integer.parseInt(editIdStr);
                        Society originalSociety = societyMapper.selectSocietyById(societyId);
                        
                        if (originalSociety != null) {
                            // 创建协会对象并设置更新后的值
                            Society editSociety = new Society();
                            editSociety.setSocietyId(societyId);
                            editSociety.setSocietyName(editSocietyName);
                            editSociety.setSocietyCreator(Integer.parseInt(editSocietyCreatorStr));
                            editSociety.setSocietyIntro(editSocietyIntro);
                            editSociety.setSocietyStatus(Integer.parseInt(editSocietyStatusStr));
                            // 保留原有的创建日期
                            editSociety.setSocietyCreateDate(originalSociety.getSocietyCreateDate());
                            
                            // 更新数据库
                            societyMapper.updateSociety(editSociety);
                            sqlSession.commit();
                        }
                    }
                    response.sendRedirect("society?action=list");
                    break;
                case "delete":
                    // 删除协会
                    String deleteIdStr = request.getParameter("id");
                    if (deleteIdStr != null) {
                        Integer societyId = Integer.parseInt(deleteIdStr);
                        societyMapper.deleteSocietyById(societyId);
                        sqlSession.commit();
                    }
                    response.sendRedirect("society?action=list");
                    break;
                default:
                    response.sendRedirect("society?action=list");
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