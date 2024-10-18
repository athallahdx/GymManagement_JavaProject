package com.model;


//Create New MemberForm, and replace this
public class Member {
	private Integer id;
	private String fullName;
	private String sex;
	private String phoneNumber;
	private String dateteOfBirth;
	private String isStudent;
	public Member(Integer id, String fullName, String sex, String phoneNumber, String dateteOfBirth, String isStudent) {
		this.id = id;
		this.fullName = fullName;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.dateteOfBirth = dateteOfBirth;
		this.isStudent = isStudent;
	}
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateteOfBirth() {
		return dateteOfBirth;
	}
	public void setDateteOfBirth(String dateteOfBirth) {
		this.dateteOfBirth = dateteOfBirth;
	}
	public String getIsStudent() {
		return isStudent;
	}
	public void setIsStudent(String isStudent) {
		this.isStudent = isStudent;
	}
	
	
	
	
}
