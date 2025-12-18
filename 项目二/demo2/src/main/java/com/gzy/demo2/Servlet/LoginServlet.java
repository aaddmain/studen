package com.gzy.demo2.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.gzy.demo2.entity.Student;
import com.gzy.demo2.mapper.StudentMapper;
import com.gzy.demo2.util.MyBatisUtil;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        // 获取表单数据
        String studentNumberStr = request.getParameter("studentNumber");
        String password = request.getParameter("password");
        
        try {
            int studentNumber = Integer.parseInt(studentNumberStr);
            
            // 使用MyBatis查询学生
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.selectStudentByNumber(studentNumber);
            sqlSession.close();
            
            // 验证用户
            if (student != null && student.getPassword().equals(password)) {
                // 登录成功，将用户信息存入session
                HttpSession session = request.getSession();
                session.setAttribute("student", student);
                // 跳转到主页面
                response.sendRedirect("index.jsp");
            } else {
                // 登录失败，返回登录页面并显示错误信息
                request.setAttribute("errorMsg", "学号或密码错误");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // 学号格式错误
            request.setAttribute("errorMsg", "学号必须是数字");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "登录失败，请重试");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理GET请求，跳转到登录页面
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}