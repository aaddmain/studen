package com.gzy.demo2.entity;

import java.time.LocalDate;

/**
 * 会员实体类
 */
public class Member {
    private Integer memberId;
    private Integer memberStudentId;
    private LocalDate joinDate;  // 加入日期
    private Integer memberStatus;  // 会员状态：1.正常；2.退出；3.申请退出
    private Integer memberPosition;  // 职位：1.会长、2.副会长、3.成员等
    private Integer memberSocietyId; // 所属协会id
    
    // 学生相关字段
    private Integer studentNumber;  // 学号
    private String studentName;     // 姓名
    private String gender;         // 性别
    private Integer graduated;      // 毕业状态：1.未毕业；2.已毕业

    // 无参构造方法
    public Member() {}

    // 全参构造方法
    public Member(Integer memberId, Integer memberStudentId, LocalDate joinDate,
                 Integer memberStatus, Integer memberPosition, Integer memberSocietyId) {
        this.memberId = memberId;
        this.memberStudentId = memberStudentId;
        this.joinDate = joinDate;
        this.memberStatus = memberStatus;
        this.memberPosition = memberPosition;
        this.memberSocietyId = memberSocietyId;
    }

    // Getter 和 Setter 方法
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberStudentId() {
        return memberStudentId;
    }

    public void setMemberStudentId(Integer memberStudentId) {
        this.memberStudentId = memberStudentId;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Integer memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Integer getMemberPosition() {
        return memberPosition;
    }

    public void setMemberPosition(Integer memberPosition) {
        this.memberPosition = memberPosition;
    }

    public Integer getMemberSocietyId() {
        return memberSocietyId;
    }

    public void setMemberSocietyId(Integer memberSocietyId) {
        this.memberSocietyId = memberSocietyId;
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

    public Integer getGraduated() {
        return graduated;
    }

    public void setGraduated(Integer graduated) {
        this.graduated = graduated;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberStudentId=" + memberStudentId +
                ", joinDate=" + joinDate +
                ", memberStatus=" + memberStatus +
                ", memberPosition=" + memberPosition +
                ", memberSocietyId=" + memberSocietyId +
                ", studentNumber=" + studentNumber +
                ", studentName=" + studentName +
                ", gender=" + gender +
                ", graduated=" + graduated +
                '}';
    }
}