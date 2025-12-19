package com.gzy.demo2.mapper;

import java.util.List;

import com.gzy.demo2.entity.Activity;

public interface ActivityMapper {
    /**
     * 插入活动信息
     * @param activity 活动对象
     * @return 受影响的行数
     */
    int insertActivity(Activity activity);
    
    /**
     * 删除活动信息
     * @param id 活动ID
     * @return 受影响的行数
     */
    int deleteActivityById(Integer id);
    
    /**
     * 更新活动信息
     * @param activity 活动对象
     * @return 受影响的行数
     */
    int updateActivity(Activity activity);
    
    /**
     * 更新活动状态
     * @param id 活动ID
     * @param status 活动状态
     * @return 受影响的行数
     */
    int updateActivityStatus(Integer id, String status);
    
    /**
     * 根据ID查询活动
     * @param id 活动ID
     * @return 活动对象
     */
    Activity selectActivityById(Integer id);
    
    /**
     * 查询所有活动
     * @return 活动列表
     */
    List<Activity> selectAllActivities();
    
    /**
     * 根据组织者查询活动
     * @param organizer 组织者
     * @return 活动列表
     */
    List<Activity> selectActivitiesByOrganizer(String organizer);
    
    /**
     * 根据关键词查询活动
     * @param keyword 搜索关键词
     * @return 活动列表
     */
    List<Activity> selectActivitiesByKeyword(String keyword);
}