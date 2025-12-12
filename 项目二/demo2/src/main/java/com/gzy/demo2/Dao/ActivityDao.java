package com.gzy.demo2.Dao;

import com.gzy.demo2.entity.Activity;
import java.util.List;

public interface ActivityDao {
    /**
     * 添加活动
     * @param activity 活动对象
     * @return 受影响的行数
     */
    Integer addActivity(Activity activity);
    
    /**
     * 根据ID删除活动
     * @param id 活动ID
     * @return 受影响的行数
     */
    Integer deleteActivity(Long id);
    
    /**
     * 更新活动信息
     * @param activity 活动对象
     * @return 受影响的行数
     */
    Integer updateActivity(Activity activity);
    
    /**
     * 根据ID查询活动
     * @param id 活动ID
     * @return 活动对象
     */
    Activity getActivityById(Long id);
    
    /**
     * 查询所有活动
     * @return 活动列表
     */
    List<Activity> getAllActivities();
    
    /**
     * 根据组织者查询活动
     * @param organizer 组织者
     * @return 活动列表
     */
    List<Activity> getActivitiesByOrganizer(String organizer);
    
    /**
     * 更新活动状态
     * @param id 活动ID
     * @param status 活动状态
     * @return 受影响的行数
     */
    Integer updateActivityStatus(Long id, String status);
}