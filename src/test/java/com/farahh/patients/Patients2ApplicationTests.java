package com.farahh.patients;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.farahh.patients.entities.Genre;
import com.farahh.patients.entities.Patient;
import com.farahh.patients.repos.PatientRepository;
import com.farahh.patients.service.PatientService;

@SpringBootTest
class Patients2ApplicationTests {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private PatientService patientService;
	@Test
	public void testCreatePatient() {
	Patient pats = new Patient("feriel Guelbi",222.000,new Date());
	patientRepository.save(pats);
	}
	@Test
	public void testFindPatient()
	{
	Patient p = patientRepository.findById(1L).get();
	System.out.println(p);
	}
	@Test
	public void testFindPatientByNom()
	{
	List <Patient> pats = patientRepository.findByNomPatient("farah Guelbi");
	for(Patient p:pats) {
	System.out.println(p);
	}
	}
	@Test
	
	public void testfindByNomTarifconsultation() {
	    List<Patient> pats = patientRepository.findByNomTarifconsultation("farah Guelbi", 100.0);
	    for (Patient p : pats) {
	        System.out.println(p); 
	    }
	}
	@Test
	public void testfindByGenre()
	{
	Genre gen = new Genre();
	gen.setIdGenre(1L);
	List<Patient> pats = patientRepository.findByGenre(gen);
	for (Patient p : pats)
	{
	System.out.println(p);
	}
	}
	@Test
	public void findByGenreIdGenre()
	{
	List<Patient> pats = patientRepository.findByGenreIdGenre(1L);
	for (Patient p : pats)
	{
	System.out.println(p);
	}
	 }


	@Test
	public void testFindPatientByNomContains()
	{
	List <Patient> pats = patientRepository.findByNomPatientContains("f");
	for(Patient p:pats) {
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByOrderByNomPatientAsc()
	{
	List<Patient> pats =
	patientRepository.findByOrderByNomPatientAsc();
	for (Patient p : pats)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testTrierPatientsNomsPrix()
	{
	List<Patient> pats = patientRepository.trierPatientsNomsTarif();
	for (Patient p : pats)
	{
	System.out.println(p);
	}
	}

	@Test
	public void testUpdatePatient()
	{
	Patient p = patientRepository.findById(1L).get();
	p.setTarifConsultation(1000.0);
	patientRepository.save(p);
	}
	@Test
	public void testDeletePatient()
	{
	patientRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousPatients()
	{
	List<Patient> pats = patientRepository.findAll();
	for (Patient p : pats)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomPatientContains()
	{
		   System.out.println("Test started!");
	Page<Patient> pats = patientService.getAllPatientsParPage(0,2);
	System.out.println(pats.getSize());
	System.out.println(pats.getTotalElements());
	System.out.println(pats.getTotalPages());
	pats.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Patient p : pats)
	{
	System.out.println(p);
	} */
	}

}
