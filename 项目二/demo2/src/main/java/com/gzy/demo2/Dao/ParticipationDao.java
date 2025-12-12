package com.gzy.demo2.Dao;

import com.gzy.demo2.entity.Participation;
import java.util.List;

public interface ParticipationDao {
    /**
     * 添加参与记录
     * @param participation 参与记录对象
     * @return 受影响的行数
     */
    Integer addParticipation(Participation participation);
    
    /**
     * 根据ID删除参与记录
     * @param id 参与记录ID
     * @return 受影响的行数
     */
    Integer deleteParticipation(Long id);
    
    /**
     * 更新参与记录
     * @param participation 参与记录对象
     * @return 受影响的行数
     */
    Integer updateParticipation(Participation participation);
    
    /**
     * 根据ID查询参与记录
     * @param id 参与记录ID
     * @return 参与记录对象
     */
    Participation getParticipationById(Long id);
    
    /**
     * 查询所有参与记录
     * @return 参与记录列表
     */
    List<Participation> getAllParticipations();
    
    /**
     * 根据学号查询参与记录
     * @param studentNumber 学号
     * @return 参与记录列表
     */
    List<Participation> getParticipationsByStudentNumber(String studentNumber);
    
    /**
     * 根据活动编号查询参与记录
     * @param activityNumber 活动编号
     * @return 参与记录列表
     */
    List<Participation> getParticipationsByActivityNumber(String activityNumber);
    
    /**
     * 更新参与状态
     * @param id 参与记录ID
     * @param status 参与状态
     * @return 受影响的行数
     */
    Integer updateParticipationStatus(Long id, String status);
}