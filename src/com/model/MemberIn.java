package com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberIn {
    private Integer id;  // Corresponds to `member_id`
    private String fullName;  // Corresponds to `member_name`
    private String sex;  // Corresponds to `member_sex`
    private String phoneNumber;  // Corresponds to the phone number
    private LocalDate birthdate;  // Corresponds to `member_birthdate`
    private boolean isStudent;  // Corresponds to `member_isstudent`
    private LocalDateTime registeredDate;  // Corresponds to `member_registered_date`
    private LocalDateTime lastMembershipPaymentDate;  // Corresponds to `last_membership_payment_date`
    private LocalDateTime currentMembershipDue;  // Corresponds to `current_membership_due`
    private String membershipStatus;  // To store `membership_status`

    public MemberIn(Integer id, String fullName, String sex, LocalDate birthdate, boolean isStudent, LocalDateTime registeredDate, LocalDateTime lastMembershipPaymentDate, LocalDateTime currentMembershipDue, String membershipStatus) {
        this.id = id;
        this.fullName = fullName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.isStudent = isStudent;
        this.registeredDate = registeredDate;
        this.lastMembershipPaymentDate = lastMembershipPaymentDate;
        this.currentMembershipDue = currentMembershipDue;
        this.membershipStatus = membershipStatus;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDateTime getLastMembershipPaymentDate() {
        return lastMembershipPaymentDate;
    }

    public void setLastMembershipPaymentDate(LocalDateTime lastMembershipPaymentDate) {
        this.lastMembershipPaymentDate = lastMembershipPaymentDate;
    }

    public LocalDateTime getCurrentMembershipDue() {
        return currentMembershipDue;
    }

    public void setCurrentMembershipDue(LocalDateTime currentMembershipDue) {
        this.currentMembershipDue = currentMembershipDue;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }
}
