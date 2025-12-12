package com.gzy.demo2.entity;

import java.time.LocalDateTime;

/**
 * 社团实体类
 */
public class Society {
    private Long id;
    private String societyNumber;   // 社团编号
    private String name;            // 社团名称
    private String description;     // 社团描述
    private String president;       // 社长
    private Integer memberCount;    // 成员数量
    private String contactInfo;     // 联系方式
    private LocalDateTime createTime;  // 创建时间
    private LocalDateTime updateTime;  // 更新时间

    // 无参构造方法
    public Society() {}

    // 全参构造方法
    public Society(Long id, String societyNumber, String name, String description, String president,
                   Integer memberCount, String contactInfo, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.societyNumber = societyNumber;
        this.name = name;
        this.description = description;
        this.president = president;
        this.memberCount = memberCount;
        this.contactInfo = contactInfo;
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

    public String getSocietyNumber() {
        return societyNumber;
    }

    public void setSocietyNumber(String societyNumber) {
        this.societyNumber = societyNumber;
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

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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
        return "Society{" +
                "id=" + id +
                ", societyNumber='" + societyNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", president='" + president + '\'' +
                ", memberCount=" + memberCount +
                ", contactInfo='" + contactInfo + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}