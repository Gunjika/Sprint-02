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
import javax.validation.constraints.Size;

@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	@Column(name="doctor_id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="doctor_seq")
	@SequenceGenerator(sequenceName="doctor_seq",initialValue=00,allocationSize=1,name="doctor_seq")
	private String doctorId;
	
	@NotEmpty(message="doctor name is mendatory")
	@Column(name="doctorName")
	private String doctorName;

	@NotEmpty(message="doctor Specialization is mendatory")
	@Column(name="doctorSpecialization")
	private String doctorSpecialization;
	
	@NotNull(message="contact must be mendatory")
	@Size(max=10,message="number must be of 10 digit")
	@Column(name="contactNo")
	private Long contactNo;

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
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

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
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

	public Doctor(String doctorId, @NotEmpty(message = "doctor name is mendatory") String doctorName,
			@NotEmpty(message = "doctor Specialization is mendatory") String doctorSpecialization,
			@NotNull(message = "contact must be mendatory") @Size(max = 10, message = "number must be of 10 digit") Long contactNo) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpecialization = doctorSpecialization;
		this.contactNo = contactNo;
	}

}
