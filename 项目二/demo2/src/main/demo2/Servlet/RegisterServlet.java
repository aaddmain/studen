package com.gzy.demo2.Servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.gzy.demo2.entity.Student;
import com.gzy.demo2.mapper.StudentMapper;
import com.gzy.demo2.util.MyBatisUtil;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            // 获取表单数据
            String studentNumberStr = request.getParameter("studentNumber");
            String studentName = request.getParameter("studentName");
            String gender = request.getParameter("gender");
            String birthdayStr = request.getParameter("birthday");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            
            // 验证表单数据
            if (studentNumberStr == null || studentNumberStr.isEmpty() ||
                studentName == null || studentName.isEmpty() ||
                gender == null || gender.isEmpty() ||
                birthdayStr == null || birthdayStr.isEmpty() ||
                password == null || password.isEmpty() ||
                confirmPassword == null || confirmPassword.isEmpty()) {
                request.setAttribute("errorMsg", "所有字段都不能为空");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            
            // 验证密码一致性
            if (!password.equals(confirmPassword)) {
                request.setAttribute("errorMsg", "两次输入的密码不一致");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            
            // 转换数据类型
            int studentNumber = Integer.parseInt(studentNumberStr);
            Date birthday = Date.valueOf(birthdayStr);
            
            // 使用MyBatis检查学号是否已存在
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            
            // 检查学号是否已存在
            Student existingStudent = studentMapper.selectStudentByNumber(studentNumber);
            if (existingStudent != null) {
                sqlSession.close();
                request.setAttribute("errorMsg", "该学号已注册");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            
            // 创建新学生对象
            Student newStudent = new Student();
            newStudent.setStudentNumber(studentNumber);
            newStudent.setStudentName(studentName);
            newStudent.setGender(gender);
            newStudent.setBirthday(birthday);
            newStudent.setPassword(password);
            // 设置默认值
            newStudent.setGraduated(1); // 默认未毕业
            newStudent.setAvatarPath(null); // 默认头像路径为null
            
            // 插入新学生到数据库
            int result = studentMapper.insertStudent(newStudent);
            sqlSession.commit();
            sqlSession.close();
            
            // 注册成功，跳转到登录页面
            if (result > 0) {
                // 可以选择直接跳转到登录页面，或者添加成功提示
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("errorMsg", "注册失败，请重试");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // 学号格式错误
            request.setAttribute("errorMsg", "学号必须是数字");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "注册失败，请重试");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理GET请求，跳转到注册页面
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}