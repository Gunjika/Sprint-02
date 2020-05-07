package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorDao;

@Service
public class DoctorService {
	@Autowired
	private DoctorDao DoctorDao;
	
	@Transactional
	public boolean addDoctor(Doctor doctor)
	{
		return DoctorDao.save(doctor) != null;
	}
	
	@Transactional
	public List<Doctor> show()
	{
		return DoctorDao.findAll();
	}
	
	@Transactional
	
	public void deleteDoctor(Doctor doctor)
	{
		DoctorDao.delete(doctor);
	}
	
	@Transactional
	public boolean updateDoctor(Doctor doctor,String doctorId)
	{
		return DoctorDao.save(doctor) != null;
	}

}
