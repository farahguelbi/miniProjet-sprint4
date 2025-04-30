package com.farahh.patients;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.farahh.patients.entities.Patient;
import com.farahh.patients.service.PatientService;


@SpringBootApplication
public class Patients2Application implements CommandLineRunner{
     @Autowired
     
     private RepositoryRestConfiguration repositoryRestConfiguration;	
     @Autowired
     PasswordEncoder passwordEncoder;
     public static void main(String[] args) {
		SpringApplication.run(Patients2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Password Encoded BCRYPT :******************** ");
		 System.out.println(passwordEncoder.encode("123"));
		//repositoryRestConfiguration.exposeIdsFor(Patient.class);
		
	}

}
