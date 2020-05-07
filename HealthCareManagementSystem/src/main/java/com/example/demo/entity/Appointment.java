package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="Appointment")
public class Appointment {
	@Id
	@Column(name="appointment_Id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="appointment_seq")
	@SequenceGenerator(sequenceName="appointment_seq",initialValue=011010,allocationSize=1,name="appointment_seq")
	private Long appointmentId;
	
	@Column(name="Appointment_DateAndTime")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateAndtime;
	
	@Column(name="approved")
	private boolean approved;
	
	@ManyToOne( targetEntity=Diagnostic_Center.class,cascade= CascadeType.ALL)
	@JoinColumn(name="center_Id", referencedColumnName="center_Id")
	private Diagnostic_Center diagnostic_center;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId", referencedColumnName="userId")
	private Users users;

	
	public Long getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}


	public LocalDateTime getDateAndtime() {
		return dateAndtime;
	}


	public void setDateAndtime(LocalDateTime dateAndtime) {
		this.dateAndtime = dateAndtime;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	public Diagnostic_Center getDiagnostic_center() {
		return diagnostic_center;
	}


	public void setDiagnostic_center(Diagnostic_Center diagnostic_center) {
		this.diagnostic_center = diagnostic_center;
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateAndtime=" + dateAndtime + ", approved=" + approved
				+ ", diagnostic_center=" + diagnostic_center + ", users=" + users + "]";
	}


	public Appointment(Long appointmentId, LocalDateTime dateAndtime, boolean approved,
			Diagnostic_Center diagnostic_center, Users users) {
		super();
		this.appointmentId = appointmentId;
		this.dateAndtime = dateAndtime;
		this.approved = approved;
		this.diagnostic_center = diagnostic_center;
		this.users = users;
	}


	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
