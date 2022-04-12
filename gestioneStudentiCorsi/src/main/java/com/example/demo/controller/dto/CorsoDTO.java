package com.example.demo.controller.dto;

import java.time.LocalDate;

import com.example.demo.model.Corso;

public class CorsoDTO {
	private Integer id;

	private String nome;
	
	private String descrizione;
	
	private LocalDate dataInizio;
	
	private Integer numeroEsami;

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Integer getNumeroEsami() {
		return numeroEsami;
	}

	public void setNumeroEsami(Integer numeroEsami) {
		this.numeroEsami = numeroEsami;
	}

	public CorsoDTO() {
		super();
	}
	public CorsoDTO cambiaTipoToDto (Corso corso) {
		
		CorsoDTO corsoDto = new CorsoDTO();
		corsoDto.setId(corso.getId());
		corsoDto.setNome(corso.getNome());
		corsoDto.setDescrizione(corso.getDescrizione());
		corsoDto.setDataInizio(corso.getDataInizio());
		corsoDto.setNumeroEsami(corso.getNumeroEsami());
		return corsoDto;
	}
	
	public Corso cambiaTipoFromDto (CorsoDTO corsoDto) {
		
		Corso corso = new Corso();
		corso.setId(corsoDto.getId());
		corso.setNome(corsoDto.getNome());
		corso.setDescrizione(corsoDto.getDescrizione());
		corso.setDataInizio(corsoDto.getDataInizio());
		corso.setNumeroEsami(corsoDto.getNumeroEsami());
		return corso;
	}
}
