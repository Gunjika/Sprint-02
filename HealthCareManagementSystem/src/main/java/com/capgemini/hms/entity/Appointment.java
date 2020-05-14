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
@Table(name="Appointment")
public class Appointment {
	@Id
	@Column(name = "appointment_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
	@SequenceGenerator(sequenceName = "appointment_seq", initialValue=1000,allocationSize = 1, name = "appointment_seq")
	private Integer appointmentId;

	@Column(name = "Appointment_DateAndTime")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime appointmentDateAndTime;

	@Column(name = "approved")
	private boolean approved;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
	private Users users;
	
	
//	@OneToMany(fetch = FetchType.EAGER, targetEntity = Doctor.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "appointment_Id", referencedColumnName = "appointment_Id")
//	private List<Doctor> doctorlist;

	public Appointment(Integer appointmentId, LocalDateTime appointmentDateAndTime, boolean approved, Users users
			) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDateAndTime = appointmentDateAndTime;
		this.approved = approved;
		this.users = users;
		
	}



	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
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

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDateAndTime=" + appointmentDateAndTime
				+ ", approved=" + approved + ", users=" + users +  "]";
	}
//
//	public Appointment(Integer appointmentId, LocalDateTime appointmentDateAndTime, boolean approved, Users users) {
//		super();
//		this.appointmentId = appointmentId;
//		this.appointmentDateAndTime = appointmentDateAndTime;
//		this.approved = approved;
//		this.users = users;
//	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	

}
