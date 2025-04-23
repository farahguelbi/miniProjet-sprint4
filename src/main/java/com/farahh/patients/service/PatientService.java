package com.farahh.patients.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.farahh.patients.entities.Genre;
import com.farahh.patients.entities.Patient;

public interface PatientService {
	Patient savePatient(Patient p);
	Patient updatePatient(Patient p);
	void deletePatient(Patient p);
	 void deletePatientById(Long id);
	 Patient getPatient(Long id);
	List<Patient> getAllPatients();
	Page<Patient> getAllPatientsParPage(int page, int size);
	List<Patient> findByNomPatient(String nom);
	List<Patient> findByNomPatientContains(String nom);
	List<Patient> findByNomTarif (String nom, Double prix);
	List<Patient> findByGenre(Genre genre);
	List<Patient> findByGenreIdGenre(Long id);
	List<Patient> findByOrderByNomPatientAsc();
	List<Patient> trierPatientsNomsPrix();
	List<Genre> getAllGenres();
}
