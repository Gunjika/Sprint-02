package com.capgemini.hms.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Doctor_Appointment")
public class DoctorAppointment {
	@Id
	@Column(name = "DocAppointment_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
	@SequenceGenerator(sequenceName = "appointment_seq", initialValue=1000,allocationSize = 1, name = "appointment_seq")
	private Integer DocAppointment_Id;

	@Column(name = "Appointment_DateAndTime")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime appointmentDateAndTime;

	public Integer getDocAppointment_Id() {
		return DocAppointment_Id;
	}

	public void setDocAppointment_Id(Integer docAppointment_Id) {
		DocAppointment_Id = docAppointment_Id;
	}

	public LocalDateTime getAppointmentDateAndTime() {
		return appointmentDateAndTime;
	}

	public void setAppointmentDateAndTime(LocalDateTime appointmentDateAndTime) {
		this.appointmentDateAndTime = appointmentDateAndTime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "approved")
	private boolean approved;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
	private Users users;
	
	

}
