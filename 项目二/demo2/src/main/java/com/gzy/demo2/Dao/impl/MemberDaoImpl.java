package com.gzy.demo2.Dao.impl;

import com.gzy.demo2.Dao.MemberDao;
import com.gzy.demo2.entity.Student;
import com.gzy.demo2.mapper.StudentMapper;
import com.gzy.demo2.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MemberDaoImpl implements MemberDao {
    
    // 使用MyBatis获取数据库连接
    private Connection getConnection() throws SQLException {
        return MyBatisUtil.getSqlSessionFactory().getConfiguration().getEnvironment().getDataSource().getConnection();
    }
    
    @Override
    public Integer addMember(Student student) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int result = studentMapper.insertStudent(student);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Integer deleteMember(Long id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int result = studentMapper.deleteStudentById(id);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Integer updateMember(Student student) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int result = studentMapper.updateStudent(student);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Student getMemberById(Long id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.selectStudentById(id);
        }
    }
    
    @Override
    public List<Student> getAllMembers() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.selectAllStudents();
        }
    }
}