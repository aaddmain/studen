package com.gzy.demo2.entity;

import java.time.LocalDateTime;

/**
 * 活动实体类
 */
public class Activity {
    private Long id;
    private String activityNumber;  // 活动编号
    private String name;           // 活动名称
    private String description;    // 活动描述
    private String organizer;      // 组织者(社团)
    private LocalDateTime startTime;  // 开始时间
    private LocalDateTime endTime;    // 结束时间
    private String location;       // 地点
    private Integer maxParticipants; // 最大参与人数
    private String status;         // 活动状态 (报名中、进行中、已结束等)
    private LocalDateTime createTime;  // 创建时间
    private LocalDateTime updateTime;  // 更新时间

    // 无参构造方法
    public Activity() {}

    // 全参构造方法
    public Activity(Long id, String activityNumber, String name, String description, String organizer,
                    LocalDateTime startTime, LocalDateTime endTime, String location, Integer maxParticipants,
                    String status, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.activityNumber = activityNumber;
        this.name = name;
        this.description = description;
        this.organizer = organizer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.status = status;
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

    public String getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(String activityNumber) {
        this.activityNumber = activityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "Activity{" +
                "id=" + id +
                ", activityNumber='" + activityNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", organizer='" + organizer + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", location='" + location + '\'' +
                ", maxParticipants=" + maxParticipants +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}