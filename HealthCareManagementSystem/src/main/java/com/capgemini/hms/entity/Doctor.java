package com.capgemini.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	@Column(name="doctor_id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="doctor_seq")
	@SequenceGenerator(sequenceName="doctor_seq",initialValue=1010,allocationSize=1,name="doctor_seq")
	private long doctorId;
	
	@NotEmpty(message="doctor name is mendatory")
	@Column(name="doctorName")
	private String doctorName;

	@NotEmpty(message="doctor Specialization is mendatory")
	@Column(name="doctorSpecialization")
	private String doctorSpecialization;
	
	@NotNull(message="contact must be mendatory")
	@Column(name="contactNo")
	private int contactNo;

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorSpecialization=" + doctorSpecialization
				+ ", contactNo=" + contactNo + "]";
	}

	public Doctor(long doctorId, String doctorName, String doctorSpecialization, int contactNo) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpecialization = doctorSpecialization;
		this.contactNo = contactNo;
	}

}
