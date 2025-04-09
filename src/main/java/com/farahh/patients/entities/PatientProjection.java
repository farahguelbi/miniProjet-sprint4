package com.farahh.patients.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPats", types = { Patient.class })
public interface PatientProjection {
	public String getNomPatient();
}
