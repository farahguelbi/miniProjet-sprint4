package com.farahh.patients.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.farahh.patients.entities.Genre;
import com.farahh.patients.entities.Patient;

@RepositoryRestResource(path = "rest")

public interface PatientRepository extends JpaRepository<Patient, Long> {
  List< Patient> findByNomPatient(String nom);
  List<Patient> findByNomPatientContains(String nom); 
  /*@Query("select p from Patient p where p.nomPatient like %?1% and p.Tarifconsultation > ?2")
  List<Patient> findByNomTarifconsultation(String nom, Double tarif);*/
  @Query("select p from Patient p where p.nomPatient like %:nom and p.tarifConsultation > :tarif")
  List<Patient> findByNomTarifconsultation (@Param("nom") String nom,@Param("tarif") Double tarif);
  @Query("select p from Patient p where p.genre = ?1")
  List<Patient> findByGenre (Genre genre);
  List<Patient> findByGenreIdGenre(Long id);
  List<Patient> findByOrderByNomPatientAsc();
  @Query("select p from Patient p order by p.nomPatient ASC, p.tarifConsultation DESC")
  List<Patient> trierPatientsNomsTarif ();

}
