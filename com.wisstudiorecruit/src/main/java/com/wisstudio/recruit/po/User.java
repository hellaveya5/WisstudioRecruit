package com.wisstudio.recruit.po;

/**
 * @author 98333
 */
public class User {
/*
    学号 + 姓名 + 性别 + 年级+ 所在专业 + 联系电话 + 选择方向（前端/后台） + 目前已掌握的技能介绍 + 自我介绍
*/
    String password;
    String name;
    String gender;
    String major;
    Integer grade;
    Long contactNumber;
    String skillMastered;
    String selfIntroduce;
    String choiceOfDirection;
    Long studentId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getChoiceOfDirection() {
        return choiceOfDirection;
    }

    public void setChoiceOfDirection(String choiceOfDirection) {
        this.choiceOfDirection = choiceOfDirection;
    }

    public String getSkillMastered() {
        return skillMastered;
    }

    public void setSkillMastered(String skillMastered) {
        this.skillMastered = skillMastered;
    }

    public String getSelfIntroduce() {
        return selfIntroduce;
    }

    public void setSelfIntroduce(String selfIntroduce) {
        this.selfIntroduce = selfIntroduce;
    }

    @Override
    public String toString() {
        return "User{" +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", major='" + major + '\'' +
                ", grade=" + grade +
                ", contactNumber=" + contactNumber +
                ", choiceOfDirection='" + choiceOfDirection + '\'' +
                ", skillMastered='" + skillMastered + '\'' +
                ", selfIntroduce='" + selfIntroduce + '\'' +
                '}';
    }
}
