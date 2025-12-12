package com.gzy.demo2.entity;

import java.time.LocalDateTime;

/**
 * 学生实体类
 */
public class Student {
    private Long id;
    private String studentNumber;  // 学号
    private String name;           // 姓名
    private String gender;         // 性别
    private Integer age;           // 年龄
    private String major;          // 专业
    private String phone;          // 联系电话
    private String email;          // 邮箱
    private LocalDateTime createTime;  // 创建时间
    private LocalDateTime updateTime;  // 更新时间

    // 无参构造方法
    public Student() {}

    // 全参构造方法
    public Student(Long id, String studentNumber, String name, String gender, Integer age,
                   String major, String phone, String email, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.major = major;
        this.phone = phone;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}