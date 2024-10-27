package com.model;

import javafx.beans.property.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberOut {
    private final IntegerProperty id;  
    private final StringProperty fullName;  
    private final StringProperty sex;  
    private final ObjectProperty<LocalDate> birthdate;  
    private final StringProperty phoneNumber;
    private final BooleanProperty isStudent;
    private final ObjectProperty<LocalDateTime> registeredDate;  
    private final ObjectProperty<LocalDateTime> lastMembershipPaymentDate;  
    private final ObjectProperty<LocalDateTime> currentMembershipDue; 
    private final StringProperty membershipStatus;  

    public MemberOut(Integer id, String fullName, String sex, LocalDate birthdate, String phoneNumber, boolean isStudent,
                  LocalDateTime registeredDate, LocalDateTime lastMembershipPaymentDate, 
                  LocalDateTime currentMembershipDue, String membershipStatus) {
        this.id = new SimpleIntegerProperty(id);
        this.fullName = new SimpleStringProperty(fullName);
        this.sex = new SimpleStringProperty(sex);
        this.birthdate = new SimpleObjectProperty<>(birthdate);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
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
    
    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
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
