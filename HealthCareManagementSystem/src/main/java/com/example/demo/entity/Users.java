package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Users")
public class Users {
	
@Id
@Column(name="userId")
@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_seq")
@SequenceGenerator(sequenceName="user_seq",initialValue=100,allocationSize=1,name="user_seq")
private String userId;

@NotEmpty(message="user password is mendatory")
@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$")
@Column(name="userPaswword")
private String userPassword;

@NotEmpty(message="user name is mendatory")
@Column(name="userName")
private String userName;

@NotNull(message="contact must be mendatory")
@Size(max=10,message="number must be of 10 digit")
@Column(name="contactNo")
private Long contactNo;

public Users() {
	super();
	// TODO Auto-generated constructor stub
}

@Column(name="userRole")
private String userRole;

@NotEmpty(message="emailid is mendatory")
@Column(name="emailId")
private String emailId;


public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getUserPassword() {
	return userPassword;
}

public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public Long getContactNo() {
	return contactNo;
}

public void setContactNo(Long contactNo) {
	this.contactNo = contactNo;
}

public String getUserRole() {
	return userRole;
}

public void setUserRole(String userRole) {
	this.userRole = userRole;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}


@Override
public String toString() {
	return "Users [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
			+ contactNo + ", userRole=" + userRole + ", emailId=" + emailId +  "]";
}

public Users(String userId, String userPassword, String userName, Long contactNo, String userRole, String emailId
		) {
	super();
	this.userId = userId;
	this.userPassword = userPassword;
	this.userName = userName;
	this.contactNo = contactNo;
	this.userRole = userRole;
	this.emailId = emailId;
	
}

}
