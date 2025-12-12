package com.gzy.demo2.Dao.impl;

import com.gzy.demo2.Dao.ActivityDao;
import com.gzy.demo2.entity.Activity;
import com.gzy.demo2.mapper.ActivityMapper;
import com.gzy.demo2.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ActivityDaoImpl implements ActivityDao {
    
    @Override
    public Integer addActivity(Activity activity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
            int result = activityMapper.insertActivity(activity);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Integer deleteActivity(Long id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
            int result = activityMapper.deleteActivityById(id);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Integer updateActivity(Activity activity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
            int result = activityMapper.updateActivity(activity);
            sqlSession.commit();
            return result;
        }
    }
    
    @Override
    public Activity getActivityById(Long id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
            return activityMapper.selectActivityById(id);
        }
    }
    
    @Override
    public List<Activity> getAllActivities() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
            return activityMapper.selectAllActivities();
        }
    }
    
    @Override
    public List<Activity> getActivitiesByOrganizer(String organizer) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
            return activityMapper.selectActivitiesByOrganizer(organizer);
        }
    }
    
    @Override
    public Integer updateActivityStatus(Long id, String status) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ActivityMapper activityMapper = sqlSession.getMapper(ActivityMapper.class);
            int result = activityMapper.updateActivityStatus(id, status);
            sqlSession.commit();
            return result;
        }
    }
}