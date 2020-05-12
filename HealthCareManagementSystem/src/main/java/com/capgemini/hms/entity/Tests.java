package com.capgemini.hms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class Tests {
@Id
@Column(name="test_Id")
@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="test_seq")
@SequenceGenerator(sequenceName="test_seq",initialValue=100,allocationSize=1,name="test_seq")
	private String testId;

@Column(name="testName")
	private String testName;

@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name="test_Id",referencedColumnName="test_Id")
private List<Doctor> doctorList;

public List<Doctor> getDoctorList() {
	return doctorList;
}

public void setDoctorList(List<Doctor> doctorList) {
	this.doctorList = doctorList;
}

public String getTestId() {
	return testId;
}

public void setTestId(String testId) {
	this.testId = testId;
}

public String getTestName() {
	return testName;
}

public void setTestName(String testName) {
	this.testName = testName;
}

@Override
public String toString() {
	return "Test [testId=" + testId + ", testName=" + testName + "]";
}
public Tests(String testId, String testName) {
	super();
	this.testId = testId;
	this.testName = testName;
}

public Tests() {
	super();
	// TODO Auto-generated constructor stub
}


}
