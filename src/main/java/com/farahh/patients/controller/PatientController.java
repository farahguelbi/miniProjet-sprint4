package com.farahh.patients.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farahh.patients.entities.Genre;
import com.farahh.patients.entities.Patient;
import com.farahh.patients.service.PatientService;

import jakarta.validation.Valid;

@Controller
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}

	
	
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}

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
	public String showCreate(ModelMap modelMap)
	{
		List<Genre> gens = patientService.getAllGenres();

	modelMap.addAttribute("patient", new Patient());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("genres", gens);

	return "formPatient";
	}

	/*@RequestMapping("/savePatient")
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
	}*/
	@RequestMapping("/savePatient")
	public String savePatient(@Valid Patient patient,
			 BindingResult bindingResult,
			 @RequestParam (name="page",defaultValue = "0") int page,
			 @RequestParam (name="size",defaultValue = "2") int size) {
	int currentPage;
	boolean isNew = false;
			
			if (bindingResult.hasErrors()) return "formPatient";
			if (patient.getIdPatient()==null) //ajout
				isNew=true;

			patientService.savePatient(patient);
			if (isNew) //ajout
			{
			Page<Patient> pats = patientService.getAllPatientsParPage(page, size);
			currentPage = pats.getTotalPages()-1;
			}
			else //modif
			currentPage=page;
			return ("redirect:/ListePatients?page="+currentPage+"&size="+size);
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
	public String editerPatient(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			 @RequestParam (name="size",defaultValue = "2") int size)
 {
		Patient p = patientService.getPatient(id);
	List<Genre> gens = patientService.getAllGenres();

		modelMap.addAttribute("patient", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("genres", gens);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);




		return "formPatient";
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
