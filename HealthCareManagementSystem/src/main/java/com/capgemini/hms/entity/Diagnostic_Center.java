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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Diagnostic_Center")
public class Diagnostic_Center {

	@Id
	@Column(name="center_id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="center_seq")
	@SequenceGenerator(sequenceName="center_seq",initialValue=2000,allocationSize=1,name="center_seq")
	private String centerId;
	
	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	@Column(name="centerName")
	private String centerName;
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity = Tests.class, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "center_id", referencedColumnName = "center_id")
	public List<Tests> listOftests;

	@OneToMany(fetch=FetchType.EAGER,targetEntity = Appointment.class, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "center_id", referencedColumnName = "center_id")
	private List<Appointment> appointment;

	

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<Tests> getListOftests() {
		return listOftests;
	}

	public void setListOftests(List<Tests> listOftests) {
		this.listOftests = listOftests;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", listOftests=" + listOftests
				+ ", appointment=" + appointment + "]";
	}


	public Diagnostic_Center(String centerId, String centerName, List<Tests> listOftests,
			List<Appointment> appointment) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.listOftests = listOftests;
		this.appointment = appointment;
	}

	public Diagnostic_Center() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
