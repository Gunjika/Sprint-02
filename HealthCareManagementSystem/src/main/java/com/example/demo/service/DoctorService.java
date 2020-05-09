package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Doctor;

public interface DoctorService {
	Doctor createDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor);
	List<Doctor> getAllDoctor();
	Doctor getDoctorById(long doctorId);
	void deleteDoctor(long id);

}
