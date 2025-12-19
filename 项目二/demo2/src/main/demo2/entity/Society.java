package com.gzy.demo2.entity;

import java.time.LocalDate;

/**
 * 社团实体类
 */
public class Society {
    private Integer societyId;
    private Integer societyCreator;   // 创始人的学生id
    private LocalDate societyCreateDate;  // 创建时间
    private String societyName;        // 协会名
    private String societyIntro;       // 协会简介
    private Integer societyStatus;     // 协会状态：1.正常；2.停招；3.停运

    // 无参构造方法
    public Society() {}

    // 全参构造方法
    public Society(Integer societyId, Integer societyCreator, LocalDate societyCreateDate,
                   String societyName, String societyIntro, Integer societyStatus) {
        this.societyId = societyId;
        this.societyCreator = societyCreator;
        this.societyCreateDate = societyCreateDate;
        this.societyName = societyName;
        this.societyIntro = societyIntro;
        this.societyStatus = societyStatus;
    }

    // Getter 和 Setter 方法
    public Integer getSocietyId() {
        return societyId;
    }

    public void setSocietyId(Integer societyId) {
        this.societyId = societyId;
    }

    public Integer getSocietyCreator() {
        return societyCreator;
    }

    public void setSocietyCreator(Integer societyCreator) {
        this.societyCreator = societyCreator;
    }

    public LocalDate getSocietyCreateDate() {
        return societyCreateDate;
    }

    public void setSocietyCreateDate(LocalDate societyCreateDate) {
        this.societyCreateDate = societyCreateDate;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getSocietyIntro() {
        return societyIntro;
    }

    public void setSocietyIntro(String societyIntro) {
        this.societyIntro = societyIntro;
    }

    public Integer getSocietyStatus() {
        return societyStatus;
    }

    public void setSocietyStatus(Integer societyStatus) {
        this.societyStatus = societyStatus;
    }

    @Override
    public String toString() {
        return "Society{" +
                "societyId=" + societyId +
                ", societyCreator=" + societyCreator +
                ", societyCreateDate=" + societyCreateDate +
                ", societyName='" + societyName + '\'' +
                ", societyIntro='" + societyIntro + '\'' +
                ", societyStatus=" + societyStatus +
                '}';
    }
}