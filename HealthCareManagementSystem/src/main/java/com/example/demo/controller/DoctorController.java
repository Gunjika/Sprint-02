package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;


@RestController
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> getAllDoctor(){
		return ResponseEntity.ok().body(doctorService.getAllDoctor());
	}
	@GetMapping("/doctors/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable long id){
		return ResponseEntity.ok().body(doctorService.getDoctorById(id));
	}

	@PostMapping("/doctors")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
		return ResponseEntity.ok().body(this.doctorService.createDoctor(doctor));
		
	}
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable long id,@RequestBody Doctor doctor){
		doctor.setDoctorId(id);
		return ResponseEntity.ok().body(this.doctorService.updateDoctor(doctor));
	}
	@DeleteMapping("/doctors/{id}")
	public HttpStatus deleteDoctor(@PathVariable long id){
		this.doctorService.deleteDoctor(id);
//		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
		return HttpStatus.OK;
	}
	
}
