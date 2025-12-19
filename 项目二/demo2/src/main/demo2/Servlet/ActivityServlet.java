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

import com.gzy.demo2.entity.Activity;
import com.gzy.demo2.mapper.ActivityMapper;
import com.gzy.demo2.util.MyBatisUtil;

@WebServlet(name = "activityServlet", value = "/activity")
public class ActivityServlet extends HttpServlet {
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
            ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
            
            switch (action) {
                case "list":
                    // 查询所有活动或根据关键词搜索
                    String keyword = request.getParameter("keyword");
                    List<Activity> activities;
                    if (keyword != null && !keyword.isEmpty()) {
                        // 根据关键词搜索活动
                        activities = activityMapper.selectActivitiesByKeyword(keyword);
                    } else {
                        // 查询所有活动
                        activities = activityMapper.selectAllActivities();
                    }
                    request.setAttribute("activities", activities);
                    request.getRequestDispatcher("activity/list.jsp").forward(request, response);
                    break;
                case "detail":
                    // 查询活动详情
                    String idStr = request.getParameter("id");
                    if (idStr != null) {
                        Integer activityId = Integer.parseInt(idStr);
                        Activity activity = activityMapper.selectActivityById(activityId);
                        request.setAttribute("activity", activity);
                        request.getRequestDispatcher("activity/detail.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("activity?action=list");
                    }
                    break;
                case "create":
                    // 跳转到活动创建页面
                    request.getRequestDispatcher("activity/create.jsp").forward(request, response);
                    break;
                case "edit":
                    // 查询活动信息，跳转到编辑页面
                    String editIdStr = request.getParameter("id");
                    if (editIdStr != null) {
                        Integer activityId = Integer.parseInt(editIdStr);
                        Activity activity = activityMapper.selectActivityById(activityId);
                        request.setAttribute("activity", activity);
                        request.getRequestDispatcher("activity/edit.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("activity?action=list");
                    }
                    break;
                default:
                    // 默认跳转到活动列表页面
                    List<Activity> defaultActivities = activityMapper.selectAllActivities();
                    request.setAttribute("activities", defaultActivities);
                    request.getRequestDispatcher("activity/list.jsp").forward(request, response);
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
            ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
            
            // 定义表单变量
            String activityIdStr = null;
            String activityName = null;
            String activitySocietyIdStr = null;
            String activityIntro = null;
            String activityStartTimeStr = null;
            String activityEndTimeStr = null;
            
            switch (action) {
                case "create":
                    // 创建活动
                    // 获取表单数据
                    activityName = request.getParameter("activityName");
                    activitySocietyIdStr = request.getParameter("activitySocietyId");
                    activityIntro = request.getParameter("activityIntro");
                    activityStartTimeStr = request.getParameter("activityStartTime");
                    activityEndTimeStr = request.getParameter("activityEndTime");
                    
                    if (activityName != null && activitySocietyIdStr != null && activityIntro != null && 
                        activityStartTimeStr != null && activityEndTimeStr != null) {
                        try {
                            // 转换数据类型
                            // activitySocietyId直接使用字符串，不需要转换为Integer
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                            java.util.Date activityStartTimeUtil = sdf.parse(activityStartTimeStr);
                            java.util.Date activityEndTimeUtil = sdf.parse(activityEndTimeStr);
                            
                            // 将java.util.Date转换为LocalDateTime
                            java.time.ZonedDateTime zdtStart = activityStartTimeUtil.toInstant().atZone(java.time.ZoneId.systemDefault());
                            java.time.LocalDateTime activityStartTime = zdtStart.toLocalDateTime();
                            
                            java.time.ZonedDateTime zdtEnd = activityEndTimeUtil.toInstant().atZone(java.time.ZoneId.systemDefault());
                            java.time.LocalDateTime activityEndTime = zdtEnd.toLocalDateTime();
                            
                            // 创建活动对象
                            Activity activity = new Activity();
                            activity.setActivityName(activityName);
                            activity.setActivitySocietyId(activitySocietyIdStr);
                            activity.setActivityIntro(activityIntro);
                            activity.setActivityStartTime(activityStartTime);
                            activity.setActivityEndTime(activityEndTime);
                            
                            // 插入数据库
                            activityMapper.insertActivity(activity);
                            sqlSession.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            sqlSession.rollback();
                        }
                    }
                    response.sendRedirect("activity?action=list");
                    break;
                case "edit":
                    // 编辑活动
                    // 获取表单数据
                    activityIdStr = request.getParameter("activityId");
                    activityName = request.getParameter("activityName");
                    activitySocietyIdStr = request.getParameter("activitySocietyId");
                    activityIntro = request.getParameter("activityIntro");
                    activityStartTimeStr = request.getParameter("activityStartTime");
                    activityEndTimeStr = request.getParameter("activityEndTime");
                    
                    if (activityIdStr != null && activityName != null && activitySocietyIdStr != null && activityIntro != null && 
                        activityStartTimeStr != null && activityEndTimeStr != null) {
                        try {
                            // 转换数据类型
                            Integer activityId = Integer.parseInt(activityIdStr);
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                            java.util.Date activityStartTimeUtil = sdf.parse(activityStartTimeStr);
                            java.util.Date activityEndTimeUtil = sdf.parse(activityEndTimeStr);
                            
                            // 将java.util.Date转换为LocalDateTime
                            java.time.ZonedDateTime zdtStart = activityStartTimeUtil.toInstant().atZone(java.time.ZoneId.systemDefault());
                            java.time.LocalDateTime activityStartTime = zdtStart.toLocalDateTime();
                            
                            java.time.ZonedDateTime zdtEnd = activityEndTimeUtil.toInstant().atZone(java.time.ZoneId.systemDefault());
                            java.time.LocalDateTime activityEndTime = zdtEnd.toLocalDateTime();
                            
                            // 创建活动对象
                            Activity activity = new Activity();
                            activity.setActivityId(activityId);
                            activity.setActivityName(activityName);
                            activity.setActivitySocietyId(activitySocietyIdStr);
                            activity.setActivityIntro(activityIntro);
                            activity.setActivityStartTime(activityStartTime);
                            activity.setActivityEndTime(activityEndTime);
                            
                            // 更新数据库
                            activityMapper.updateActivity(activity);
                            sqlSession.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            sqlSession.rollback();
                        }
                    }
                    response.sendRedirect("activity?action=list");
                    break;
                case "delete":
                    // 删除活动
                    String deleteIdStr = request.getParameter("id");
                    if (deleteIdStr != null) {
                        Integer activityId = Integer.parseInt(deleteIdStr);
                        activityMapper.deleteActivityById(activityId);
                        sqlSession.commit();
                    }
                    response.sendRedirect("activity?action=list");
                    break;
                default:
                    response.sendRedirect("activity?action=list");
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