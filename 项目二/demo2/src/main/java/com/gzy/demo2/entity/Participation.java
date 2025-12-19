package com.gzy.demo2.entity;

import java.time.LocalDateTime;

/**
 * 参与活动记录实体类
 */
public class Participation {
    private Long id;
    private String studentNumber;   // 学号
    private String activityNumber;  // 活动编号
    private String status;          // 参与状态 (已报名、已参加、已取消等)
    private LocalDateTime signUpTime;  // 报名时间
    private LocalDateTime createTime;  // 创建时间
    private LocalDateTime updateTime;  // 更新时间

    // 无参构造方法
    public Participation() {}

    // 全参构造方法
    public Participation(Long id, String studentNumber, String activityNumber, String status,
                         LocalDateTime signUpTime, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.activityNumber = activityNumber;
        this.status = status;
        this.signUpTime = signUpTime;
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

    public String getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(String activityNumber) {
        this.activityNumber = activityNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(LocalDateTime signUpTime) {
        this.signUpTime = signUpTime;
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
        return "Participation{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", activityNumber='" + activityNumber + '\'' +
                ", status='" + status + '\'' +
                ", signUpTime=" + signUpTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}