package com.gzy.demo2.Dao.impl;

import com.gzy.demo2.Dao.ParticipationDao;
import com.gzy.demo2.entity.Participation;
import com.gzy.demo2.mapper.ParticipationMapper;
import com.gzy.demo2.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ParticipationDaoImpl implements ParticipationDao {
    
    @Override
    public Integer addParticipation(Participation participation) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ParticipationMapper participationMapper = sqlSession.getMapper(ParticipationMapper.class);
            int result = participationMapper.insertParticipation(participation);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Integer deleteParticipation(Long id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ParticipationMapper participationMapper = sqlSession.getMapper(ParticipationMapper.class);
            int result = participationMapper.deleteParticipationById(id);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Integer updateParticipation(Participation participation) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ParticipationMapper participationMapper = sqlSession.getMapper(ParticipationMapper.class);
            int result = participationMapper.updateParticipation(participation);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Participation getParticipationById(Long id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ParticipationMapper participationMapper = sqlSession.getMapper(ParticipationMapper.class);
            return participationMapper.selectParticipationById(id);
        }
    }
    
    @Override
    public List<Participation> getAllParticipations() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ParticipationMapper participationMapper = sqlSession.getMapper(ParticipationMapper.class);
            return participationMapper.selectAllParticipations();
        }
    }
    
    @Override
    public List<Participation> getParticipationsByStudentNumber(String studentNumber) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ParticipationMapper participationMapper = sqlSession.getMapper(ParticipationMapper.class);
            return participationMapper.selectParticipationsByStudentNumber(studentNumber);
        }
    }
    
    @Override
    public List<Participation> getParticipationsByActivityNumber(String activityNumber) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ParticipationMapper participationMapper = sqlSession.getMapper(ParticipationMapper.class);
            return participationMapper.selectParticipationsByActivityNumber(activityNumber);
        }
    }
    
    @Override
    public Integer updateParticipationStatus(Long id, String status) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ParticipationMapper participationMapper = sqlSession.getMapper(ParticipationMapper.class);
            int result = participationMapper.updateParticipationStatus(id, status);
            sqlSession.commit();
            return result;
        }
    }
}