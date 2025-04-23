package com.farahh.patients.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farahh.patients.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>  {



}
