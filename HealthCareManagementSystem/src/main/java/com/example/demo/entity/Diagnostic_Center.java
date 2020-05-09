package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Diagnostic_Center")
public class Diagnostic_Center {

	@Id
	@Column(name="center_id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="center_seq")
	@SequenceGenerator(sequenceName="center_seq",initialValue=100,allocationSize=1,name="center_seq")
	private String centerId;
	
	@Column(name="centerName")
	private String centerName;
	
	@OneToMany(targetEntity=TestDetails.class, cascade=CascadeType.ALL)
	@JoinColumn(name="center_Id", referencedColumnName="center_Id")
	private List<TestDetails> test =new ArrayList<TestDetails>();

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<TestDetails> getTest() {
		return test;
	}

	public void setTest(List<TestDetails> test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "Diagnostic_Center [centerId=" + centerId + ", centerName=" + centerName + ", test=" + test + "]";
	}

	public Diagnostic_Center(String centerId, String centerName, List<TestDetails> test) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.test = test;
	}

	public Diagnostic_Center() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
