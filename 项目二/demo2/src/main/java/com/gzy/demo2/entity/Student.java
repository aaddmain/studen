package com.gzy.demo2.entity;

import java.sql.Date;

/**
 * 学生实体类
 */
public class Student {
    private Integer studentId;
    private Integer studentNumber;  // 学号
    private String studentName;     // 姓名
    private String gender;         // 性别
    private Date birthday;     // 生日
    private String password;       // 密码
    private Integer graduated;      // 毕业状态：1.未毕业；2.已毕业
    private String avatarPath;      // 头像路径

    // 无参构造方法
    public Student() {}

    // 全参构造方法
    public Student(Integer studentId, Integer studentNumber, String studentName, String gender,
                   Date birthday, String password, Integer graduated, String avatarPath) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.gender = gender;
        this.birthday = birthday;
        this.password = password;
        this.graduated = graduated;
        this.avatarPath = avatarPath;
    }

    // Getter 和 Setter 方法
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGraduated() {
        return graduated;
    }

    public void setGraduated(Integer graduated) {
        this.graduated = graduated;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber=" + studentNumber +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                ", graduated=" + graduated +
                ", avatarPath='" + avatarPath + '\'' +
                '}';
    }
    
}