package com.capgemini.hms.service;

import java.util.List;

import com.capgemini.hms.entity.Doctor;

public interface DoctorService {
	Doctor createDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor);
	List<Doctor> getAllDoctor();
	Doctor getDoctorById(long doctorId);
	void deleteDoctor(long id);

}
