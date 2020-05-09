package com.capgemini.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.hms.entity.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Long>{

}
