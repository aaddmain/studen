package com.gzy.demo2.entity;

import java.time.LocalDateTime;

/**
 * 活动实体类
 */
public class Activity {
    private Integer activityId;  // 活动ID
    private String activitySocietyId;  // 活动社团ID
    private String activityName;  // 活动名称
    private String activityIntro;  // 活动介绍
    private LocalDateTime activityStartTime;  // 活动开始时间
    private LocalDateTime activityEndTime;  // 活动结束时间

    // 无参构造方法
    public Activity() {}

    // 全参构造方法
    public Activity(Integer activityId, String activitySocietyId, String activityName, String activityIntro,
                    LocalDateTime activityStartTime, LocalDateTime activityEndTime) {
        this.activityId = activityId;
        this.activitySocietyId = activitySocietyId;
        this.activityName = activityName;
        this.activityIntro = activityIntro;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
    }

    // Getter 和Setter 方法
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivitySocietyId() {
        return activitySocietyId;
    }

    public void setActivitySocietyId(String activitySocietyId) {
        this.activitySocietyId = activitySocietyId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityIntro() {
        return activityIntro;
    }

    public void setActivityIntro(String activityIntro) {
        this.activityIntro = activityIntro;
    }

    public LocalDateTime getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(LocalDateTime activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public LocalDateTime getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(LocalDateTime activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", activitySocietyId='" + activitySocietyId + '\'' +
                ", activityName='" + activityName + '\'' +
                ", activityIntro='" + activityIntro + '\'' +
                ", activityStartTime=" + activityStartTime +
                ", activityEndTime=" + activityEndTime +
                '}';
    }
}