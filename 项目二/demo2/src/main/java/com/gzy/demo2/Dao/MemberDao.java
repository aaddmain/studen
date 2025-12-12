package com.gzy.demo2.Dao;

import com.gzy.demo2.entity.Student;
import java.util.List;

public interface MemberDao {
    /**
     * 添加学生会员
     * @param student 学生对象
     * @return 受影响的行数
     */
    Integer addMember(Student student);
    
    /**
     * 根据ID删除学生会员
     * @param id 学生ID
     * @return 受影响的行数
     */
    Integer deleteMember(Long id);
    
    /**
     * 更新学生会员信息
     * @param student 学生对象
     * @return 受影响的行数
     */
    Integer updateMember(Student student);
    
    /**
     * 根据ID查询学生会员
     * @param id 学生ID
     * @return 学生对象
     */
    Student getMemberById(Long id);
    
    /**
     * 查询所有学生会员
     * @return 学生列表
     */
    List<Student> getAllMembers();
}