package com.gzy.demo2.mapper;

import com.gzy.demo2.entity.Member;
import java.util.List;

/**
 * 会员Mapper接口
 */
public interface MemberMapper {
    /**
     * 插入会员信息
     * @param member 会员对象
     * @return 受影响的行数
     */
    int insertMember(Member member);
    
    /**
     * 删除会员信息
     * @param memberId 会员ID
     * @return 受影响的行数
     */
    int deleteMemberById(Integer memberId);
    
    /**
     * 更新会员信息
     * @param member 会员对象
     * @return 受影响的行数
     */
    int updateMember(Member member);
    
    /**
     * 更新会员状态
     * @param memberId 会员ID
     * @param memberStatus 会员状态
     * @return 受影响的行数
     */
    int updateMemberStatus(Integer memberId, Integer memberStatus);
    
    /**
     * 根据ID查询会员
     * @param memberId 会员ID
     * @return 会员对象
     */
    Member selectMemberById(Integer memberId);
    
    /**
     * 查询所有会员
     * @return 会员列表
     */
    List<Member> selectAllMembers();
    
    /**
     * 根据学生ID查询会员
     * @param memberStudentId 学生ID
     * @return 会员对象
     */
    Member selectMemberByStudentId(Integer memberStudentId);
    
    /**
     * 根据学生ID查询所有会员记录
     * @param memberStudentId 学生ID
     * @return 会员列表
     */
    List<Member> selectMembersByStudentId(Integer memberStudentId);
    
    /**
     * 根据社团ID查询会员
     * @param memberSocietyId 社团ID
     * @return 会员列表
     */
    List<Member> selectMembersBySocietyId(Integer memberSocietyId);
    
    /**
     * 根据状态查询会员
     * @param memberStatus 会员状态
     * @return 会员列表
     */
    List<Member> selectMembersByStatus(Integer memberStatus);
    
    /**
     * 根据社团ID和状态查询会员
     * @param memberSocietyId 社团ID
     * @param memberStatus 会员状态
     * @return 会员列表
     */
    List<Member> selectMembersBySocietyIdAndStatus(Integer memberSocietyId, Integer memberStatus);
    
    /**
     * 根据关键词搜索会员
     * @param keyword 搜索关键词
     * @return 会员列表
     */
    List<Member> selectMembersByKeyword(String keyword);
}