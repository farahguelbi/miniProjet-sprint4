package com.farahh.patients.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idPatient;
	@NotNull
	@Size (min = 4,max = 15)
   private String nomPatient;
	@Min(value = 10)
	 @Max(value = 10000)
	
   private Double tarifConsultation;
   @Temporal(TemporalType.DATE)
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   @PastOrPresent

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
	tarifConsultation = tarifconsultation;
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

public Double getTarifConsultation() {
	return tarifConsultation;
}


public void setTarifConsultation(Double tarifconsultation) {
	this.tarifConsultation = tarifconsultation;
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
			+ tarifConsultation + ", dateConsultation=" + dateConsultation + "]";
}
   
public Genre getGenre() {
	return genre;
}


public void setGenre(Genre genre) {
	this.genre = genre;
}


   
}
