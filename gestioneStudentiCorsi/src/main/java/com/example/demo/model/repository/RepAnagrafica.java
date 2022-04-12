package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Anagrafica;

@Repository
public interface RepAnagrafica extends JpaRepository <Anagrafica, Integer> {

	Anagrafica findByCodiceFiscale(String codiceFiscale);

}
