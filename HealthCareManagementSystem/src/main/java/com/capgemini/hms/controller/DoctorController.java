package com.capgemini.hms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hms.entity.Doctor;
import com.capgemini.hms.exception.DoctorNotFoundException;
import com.capgemini.hms.service.DoctorService;

@CrossOrigin(origins="http://localhost:4200") 
@RestController
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@CrossOrigin
	@GetMapping("/viewallDoctor")
	public ResponseEntity<List<Doctor>> getallDoctor() {
		List<Doctor> doctorList = doctorService.showallDoctor();
		return new ResponseEntity<List<Doctor>>(doctorList, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/addDoctor")
	public ResponseEntity<String> addDoctor(@Valid @RequestBody Doctor doctor, BindingResult bindingResult)
			throws DoctorNotFoundException {
		String err = "";
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new DoctorNotFoundException(err);
		}
		try {
			doctorService.addDoctor(doctor);
			return new ResponseEntity<String>("Doctor added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new DoctorNotFoundException("Doctor ID already exists");
		}
	}
	
	@DeleteMapping(value = "/deleteDoctor/{doctorId}")
	public ResponseEntity<String> deleteDoctor(@Valid @PathVariable int doctorId)
			throws DoctorNotFoundException {
		try {
			doctorService.deleteDoctor(doctorId);
			return new ResponseEntity<String>("doctor deleted successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new DoctorNotFoundException("Doctor ID not exists");
		}
	}
	@CrossOrigin
	@PutMapping("/updateDoctor/{doctorId}")
	public ResponseEntity<String> updateDoctor(@Valid @RequestBody Doctor doctor, @PathVariable int doctorId,BindingResult bindingResult)throws DoctorNotFoundException
	{
		String err = "";
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new DoctorNotFoundException(err);
		}
		try
		{
			doctorService.updateDoctor(doctor, doctorId);
			return new ResponseEntity<String>("Doctor added successfully", HttpStatus.OK);

		}
		catch (DataIntegrityViolationException ex) {
			throw new DoctorNotFoundException("Doctor ID doesnot exists");
		}
	}
	@GetMapping("/doctors/{doctorId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorId){
		return ResponseEntity.ok().body(doctorService.getDoctorById(doctorId));
	}
//	

	
	
	
//	@GetMapping("/doctors")
//	public ResponseEntity<List<Doctor>> getAllDoctor(){
//		return ResponseEntity.ok().body(doctorService.getAllDoctor());
//	}
//	@GetMapping("/doctors/{id}")
//	public ResponseEntity<Doctor> getDoctorById(@PathVariable long id){
//		return ResponseEntity.ok().body(doctorService.getDoctorById(id));
//	}
//
//	@PostMapping("/doctors")
//	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
//		return ResponseEntity.ok().body(this.doctorService.createDoctor(doctor));
//		
//	}
//	@PutMapping("/doctors/{id}")
//	public ResponseEntity<Doctor> updateDoctor(@PathVariable long id,@RequestBody Doctor doctor){
//		doctor.setDoctorId(id);
//		return ResponseEntity.ok().body(this.doctorService.updateDoctor(doctor));
//	}
//	@DeleteMapping("/doctors/{id}")
//	public HttpStatus deleteDoctor(@PathVariable long id){
//		this.doctorService.deleteDoctor(id);
////		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
//		return HttpStatus.OK;
//	}
	
}
