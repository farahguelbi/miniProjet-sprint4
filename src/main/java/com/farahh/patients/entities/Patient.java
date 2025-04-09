package com.farahh.patients.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idPatient;
   private String nomPatient;
   private Double Tarifconsultation;
   private Date dateConsultation;
   
   @ManyToOne
   @JoinColumn(name = "genre_id_genre")
   private Genre genre;
   
   

public Patient() {
	super();
	// TODO Auto-generated constructor stub
}


public Patient(String nomPatient, Double tarifconsultation, Date dateConsultation) {
	super();
	this.nomPatient = nomPatient;
	Tarifconsultation = tarifconsultation;
	this.dateConsultation = dateConsultation;
}


public Long getIdPatient() {
	return idPatient;
}
public void setIdPatient(Long idPatient) {
	this.idPatient = idPatient;
}
public String getNomPatient() {
	return nomPatient;
}
public void setNomPatient(String nomPatient) {
	this.nomPatient = nomPatient;
}

public Double getTarifconsultation() {
	return Tarifconsultation;
}


public void setTarifconsultation(Double tarifconsultation) {
	Tarifconsultation = tarifconsultation;
}


public Date getDateConsultation() {
	return dateConsultation;
}
public void setDateConsultation(Date dateConsultation) {
	this.dateConsultation = dateConsultation;
}

@Override
public String toString() {
	return "Patient [idPatient=" + idPatient + ", nomPatient=" + nomPatient + ", Tarif_consultation="
			+ Tarifconsultation + ", dateConsultation=" + dateConsultation + "]";
}
   
public Genre getGenre() {
	return genre;
}


public void setGenre(Genre genre) {
	this.genre = genre;
}


   
}
