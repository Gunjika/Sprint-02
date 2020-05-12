package com.capgemini.hms.entity;

import java.math.BigInteger;

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
@Table(name="User_Table")
public class Users {
	
	@Id
	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(sequenceName = "user_seq", initialValue = 1, allocationSize = 1, name = "user_seq")
	private Integer userId;

	@NotEmpty(message = "user password is mandatory")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$")
	@Column(name = "userPaswword")
	private String userPassword;

	@NotEmpty(message = "user name is mandatory")
	@Column(name = "userName")
	private String userName;

	@NotNull(message = "contact must be mandatory")
	@Column(name = "contactNo")
	private BigInteger contactNo;

	@Column(name = "userRole")
	private String userRole;

	@NotEmpty(message = "emailid is mandatory")
	@Column(name = "emailId")
	private String emailId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public BigInteger getContactNo() {
		return contactNo;
	}

	public void setContactNo(BigInteger contactNo) {
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

	public Users(Integer userId,
			@NotEmpty(message = "user password is mandatory") @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$") String userPassword,
			@NotEmpty(message = "user name is mandatory") String userName,
			@NotNull(message = "contact must be mandatory") @Size(max = 10, message = "number must be of 10 digit") BigInteger contactNo,
			String userRole, @NotEmpty(message = "emailid is mandatory") String emailId) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.userRole = userRole;
		this.emailId = emailId;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
				+ contactNo + ", userRole=" + userRole + ", emailId=" + emailId + "]";
	}


}
