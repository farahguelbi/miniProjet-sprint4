package com.farahh.patients.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farahh.patients.entities.Patient;
import com.farahh.patients.service.PatientService;

@Controller
public class PatientController {
	@Autowired
	PatientService patientService;

	@RequestMapping("/ListePatients")
	public String listePatients(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size	
			) {
		Page<Patient> pats = patientService.getAllPatientsParPage(page, size);
		modelMap.addAttribute("patients", pats);
		 modelMap.addAttribute("pages", new int[pats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listePatients";

	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createPatient";
	}

	@RequestMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateConsultation = dateformat.parse(String.valueOf(date));
		patient.setDateConsultation(dateConsultation);

		Patient savePatient = patientService.savePatient(patient);
		String msg = "patient enregistré avec Id " + savePatient.getIdPatient();
		modelMap.addAttribute("msg", msg);
		return "createPatient";
	}

	@RequestMapping("/supprimerPatient")
	public String supprimerPatient(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size
			) {
		patientService.deletePatientById(id);
		Page<Patient> pats = patientService.getAllPatientsParPage(page,
				size);
		modelMap.addAttribute("patients", pats);
		modelMap.addAttribute("pages", new int[pats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listePatients";
	}

	@RequestMapping("/modifierPatient")
	public String editerPatient(@RequestParam("id") Long id, ModelMap modelMap) {
		Patient p = patientService.getPatient(id);
		modelMap.addAttribute("patient", p);
		return "editerPatient";
	}

	@RequestMapping("/updatePatient")
	public String updatePatient(@ModelAttribute("patient") Patient patient, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateConsultation = dateformat.parse(String.valueOf(date));
		patient.setDateConsultation(dateConsultation);

		patientService.updatePatient(patient);
		List<Patient> pats = patientService.getAllPatients();
		modelMap.addAttribute("patients", pats);
		return "listePatients";
	}
	
}
