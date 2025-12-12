package com.gzy.demo2.Dao.impl;

import com.gzy.demo2.Dao.SocietyDao;
import com.gzy.demo2.entity.Society;
import com.gzy.demo2.mapper.SocietyMapper;
import com.gzy.demo2.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SocietyDaoImpl implements SocietyDao {
    
    // 使用MyBatis获取数据库连接
    private Connection getConnection() throws SQLException {
        return MyBatisUtil.getSqlSessionFactory().getConfiguration().getEnvironment().getDataSource().getConnection();
    }
    
    @Override
    public Integer addSociety(Society society) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
            int result = societyMapper.insertSociety(society);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Integer deleteSociety(Long id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
            int result = societyMapper.deleteSocietyById(id);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Integer updateSociety(Society society) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
            int result = societyMapper.updateSociety(society);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Society getSocietyById(Long id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
            return societyMapper.selectSocietyById(id);
        }
    }
    
    @Override
    public List<Society> getAllSocieties() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
            return societyMapper.selectAllSocieties();
        }
    }
    
    @Override
    public Society getSocietyByName(String name) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            SocietyMapper societyMapper = sqlSession.getMapper(SocietyMapper.class);
            return societyMapper.selectSocietyByName(name);
        }
    }
}