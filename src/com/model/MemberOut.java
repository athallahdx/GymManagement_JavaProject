package com.model;

import javafx.beans.property.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberOut {
    private final IntegerProperty id;  // Corresponds to `member_id`
    private final StringProperty fullName;  // Corresponds to `member_name`
    private final StringProperty sex;  // Corresponds to `member_sex`
    private final ObjectProperty<LocalDate> birthdate;  // Corresponds to `member_birthdate`
    private final BooleanProperty isStudent;  // Corresponds to `member_isstudent`
    private final ObjectProperty<LocalDateTime> registeredDate;  // Corresponds to `member_registered_date`
    private final ObjectProperty<LocalDateTime> lastMembershipPaymentDate;  // Corresponds to `last_membership_payment_date`
    private final ObjectProperty<LocalDateTime> currentMembershipDue;  // Corresponds to `current_membership_due`
    private final StringProperty membershipStatus;  // To store `membership_status`

    public MemberOut(Integer id, String fullName, String sex, LocalDate birthdate, boolean isStudent,
                  LocalDateTime registeredDate, LocalDateTime lastMembershipPaymentDate, 
                  LocalDateTime currentMembershipDue, String membershipStatus) {
        this.id = new SimpleIntegerProperty(id);
        this.fullName = new SimpleStringProperty(fullName);
        this.sex = new SimpleStringProperty(sex);
        this.birthdate = new SimpleObjectProperty<>(birthdate);
        this.isStudent = new SimpleBooleanProperty(isStudent);
        this.registeredDate = new SimpleObjectProperty<>(registeredDate);
        this.lastMembershipPaymentDate = new SimpleObjectProperty<>(lastMembershipPaymentDate);
        this.currentMembershipDue = new SimpleObjectProperty<>(currentMembershipDue);
        this.membershipStatus = new SimpleStringProperty(membershipStatus);
    }

    // Getters and Setters

    public IntegerProperty idProperty() {
        return id;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public StringProperty sexProperty() {
        return sex;
    }

    public String getSex() {
        return sex.get();
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public ObjectProperty<LocalDate> birthdateProperty() {
        return birthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate.get();
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate.set(birthdate);
    }

    public BooleanProperty isStudentProperty() {
        return isStudent;
    }

    public boolean isStudent() {
        return isStudent.get();
    }

    public void setStudent(boolean isStudent) {
        this.isStudent.set(isStudent);
    }

    public ObjectProperty<LocalDateTime> registeredDateProperty() {
        return registeredDate;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate.get();
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate.set(registeredDate);
    }

    public ObjectProperty<LocalDateTime> lastMembershipPaymentDateProperty() {
        return lastMembershipPaymentDate;
    }

    public LocalDateTime getLastMembershipPaymentDate() {
        return lastMembershipPaymentDate.get();
    }

    public void setLastMembershipPaymentDate(LocalDateTime lastMembershipPaymentDate) {
        this.lastMembershipPaymentDate.set(lastMembershipPaymentDate);
    }

    public ObjectProperty<LocalDateTime> currentMembershipDueProperty() {
        return currentMembershipDue;
    }

    public LocalDateTime getCurrentMembershipDue() {
        return currentMembershipDue.get();
    }

    public void setCurrentMembershipDue(LocalDateTime currentMembershipDue) {
        this.currentMembershipDue.set(currentMembershipDue);
    }

    public StringProperty membershipStatusProperty() {
        return membershipStatus;
    }

    public String getMembershipStatus() {
        return membershipStatus.get();
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus.set(membershipStatus);
    }
}
