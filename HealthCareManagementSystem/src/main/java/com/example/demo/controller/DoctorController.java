package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@RestController
public class DoctorController {
	@Autowired
	 private DoctorService doctorService;
	
	@RequestMapping (value="/addDoctor", method= RequestMethod.PUT)
	public HttpStatus insert(@RequestBody Doctor doctor)
	{
		return doctorService.addDoctor(doctor)?
		HttpStatus.CREATED:HttpStatus.BAD_REQUEST;			
	}
	
	 @RequestMapping (value="/showDoctor", method= RequestMethod.GET)
   public List<Doctor> getAllDoctor()
   {
   return doctorService.show();
   }
	
	
	@RequestMapping (value="/update/{id}", method= RequestMethod.PUT)
	public boolean update(@RequestBody Doctor doctor, @PathVariable String doctorId)
	{
		return doctorService.updateDoctor(doctor, doctorId);
	}

}
