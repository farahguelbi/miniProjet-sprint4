package com.farahh.patients.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farahh.patients.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
