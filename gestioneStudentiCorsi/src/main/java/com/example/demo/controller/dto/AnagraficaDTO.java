package com.example.demo.controller.dto;

import java.time.LocalDate;

import com.example.demo.model.Anagrafica;

public class AnagraficaDTO {
	private Integer id;
	private String nome;
	private String cognome;
	private LocalDate dob;
	private String codiceFiscale;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codice_fiscale) {
		this.codiceFiscale = codice_fiscale;
	}
	
	public AnagraficaDTO() {
		super();
	}
	
	
	public static AnagraficaDTO cambiaTipoToDto (Anagrafica anagrafica) {
		AnagraficaDTO anagraficaDto = new AnagraficaDTO();
		anagraficaDto.setId(anagrafica.getId());
		anagraficaDto.setNome(anagrafica.getNome());
		anagraficaDto.setCognome(anagrafica.getCognome());
		anagraficaDto.setDob(anagrafica.getDob());
		anagraficaDto.setCodiceFiscale(anagrafica.getCodiceFiscale());
		return anagraficaDto;	
	}
	
	public static Anagrafica cambiaTipoFromDto (AnagraficaDTO anagraficaDto) {
		Anagrafica anagrafica = new Anagrafica();
		anagrafica.setId(anagraficaDto.getId());
		anagrafica.setNome(anagraficaDto.getNome());
		anagrafica.setCognome(anagraficaDto.getCognome());
		anagrafica.setDob(anagraficaDto.getDob());
		anagrafica.setCodiceFiscale(anagraficaDto.getCodiceFiscale());
		return anagrafica;	
	}
	
}
