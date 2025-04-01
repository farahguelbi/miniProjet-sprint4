package com.farahh.patients;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.farahh.patients.entities.Patient;
import com.farahh.patients.service.PatientService;

@SpringBootApplication
public class Patients2Application implements CommandLineRunner{
     @Autowired
     PatientService patientService;
	public static void main(String[] args) {
		SpringApplication.run(Patients2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientService.savePatient(new Patient("manel Boulares", 2600.0, new Date()));
		patientService.savePatient(new Patient("ghofrane jemai", 2800.0, new Date()));
		patientService.savePatient(new Patient("mariem bourbiaa", 900.0, new Date()));
	}

}
