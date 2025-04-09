package com.farahh.patients.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farahh.patients.entities.Patient;
import com.farahh.patients.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PatientRESTController {
	@Autowired
     PatientService patientService;
	@RequestMapping(method=RequestMethod.GET)

	List<Patient>getAllPatients()
	{
		return patientService.getAllPatients();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Patient getPatientById(@PathVariable("id") Long id) {
	return patientService.getPatient(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Patient createPatient(@RequestBody Patient patient) {
	return patientService.savePatient(patient);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Patient updatePatient(@RequestBody Patient patient) {
	return patientService.updatePatient(patient);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePatient(@PathVariable("id") Long id)
	{
	patientService.deletePatientById(id);
	}
	@RequestMapping(value="/patsgen/{idGenre}",method = RequestMethod.GET)
	public List<Patient> getPatientsByGenId(@PathVariable("idGenre") Long idGen) {
	return patientService.findByGenreIdGenre(idGen);
	}

}
