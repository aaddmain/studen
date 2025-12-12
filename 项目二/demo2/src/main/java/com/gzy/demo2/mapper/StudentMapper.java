package com.gzy.demo2.mapper;

import java.util.List;

import com.gzy.demo2.entity.Student;

public interface StudentMapper {
    /**
     * 插入学生信息
     * @param student 学生对象
     * @return 受影响的行数
     */
    int insertStudent(Student student);
    
    /**
     * 删除学生信息
     * @param id 学生ID
     * @return 受影响的行数
     */
    int deleteStudentById(Long id);
    
    /**
     * 更新学生信息
     * @param student 学生对象
     * @return 受影响的行数
     */
    int updateStudent(Student student);
    
    /**
     * 根据ID查询学生
     * @param id 学生ID
     * @return 学生对象
     */
    Student selectStudentById(Long id);
    
    /**
     * 查询所有学生
     * @return 学生列表
     */
    List<Student> selectAllStudents();
    
    /**
     * 根据学号查询学生
     * @param studentNumber 学号
     * @return 学生对象
     */
    Student selectStudentByNumber(Integer studentNumber);
}