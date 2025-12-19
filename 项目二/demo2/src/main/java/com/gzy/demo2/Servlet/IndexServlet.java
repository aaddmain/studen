package com.gzy.demo2.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gzy.demo2.entity.Student;
import com.gzy.demo2.mapper.StudentMapper;
import com.gzy.demo2.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

@WebServlet(name = "indexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前登录用户信息
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        
        // 如果用户未登录，跳转到登录页面
        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        // 使用MyBatis查询数据
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        
        // 查询所有学生数量
        List<Student> allStudents = studentMapper.selectAllStudents();
        int studentCount = allStudents.size();
        
        // 关闭数据库连接
        sqlSession.close();
        
        // 设置页面数据
        request.setAttribute("student", student);
        request.setAttribute("studentName", student.getStudentName());
        request.setAttribute("studentCount", studentCount);
        request.setAttribute("societyCount", 25); // 模拟数据，后续需要从数据库获取
        request.setAttribute("activityCount", 85); // 模拟数据，后续需要从数据库获取
        request.setAttribute("pendingSocieties", 3); // 模拟数据，后续需要从数据库获取
        request.setAttribute("activeSocieties", 22); // 模拟数据，后续需要从数据库获取
        request.setAttribute("thisMonthActivities", 12); // 模拟数据，后续需要从数据库获取
        request.setAttribute("pendingActivities", 2); // 模拟数据，后续需要从数据库获取
        
        // 转发到首页
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}