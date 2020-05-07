package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Doctor;
@Repository
public interface DoctorDao extends JpaRepository<Doctor, String>{

}
