package com.gzy.demo2.mapper;

import com.gzy.demo2.entity.Participation;
import java.util.List;

public interface ParticipationMapper {
    /**
     * 插入参与记录
     * @param participation 参与记录对象
     * @return 受影响的行数
     */
    int insertParticipation(Participation participation);
    
    /**
     * 删除参与记录
     * @param id 参与记录ID
     * @return 受影响的行数
     */
    int deleteParticipationById(Long id);
    
    /**
     * 更新参与记录
     * @param participation 参与记录对象
     * @return 受影响的行数
     */
    int updateParticipation(Participation participation);
    
    /**
     * 更新参与状态
     * @param id 参与记录ID
     * @param status 参与状态
     * @return 受影响的行数
     */
    int updateParticipationStatus(Long id, String status);
    
    /**
     * 根据ID查询参与记录
     * @param id 参与记录ID
     * @return 参与记录对象
     */
    Participation selectParticipationById(Long id);
    
    /**
     * 查询所有参与记录
     * @return 参与记录列表
     */
    List<Participation> selectAllParticipations();
    
    /**
     * 根据学号查询参与记录
     * @param studentNumber 学号
     * @return 参与记录列表
     */
    List<Participation> selectParticipationsByStudentNumber(String studentNumber);
    
    /**
     * 根据活动编号查询参与记录
     * @param activityNumber 活动编号
     * @return 参与记录列表
     */
    List<Participation> selectParticipationsByActivityNumber(String activityNumber);
}