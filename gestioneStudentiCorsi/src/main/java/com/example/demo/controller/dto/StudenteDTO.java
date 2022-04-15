package com.example.demo.controller.dto;

import java.time.LocalDate;


import com.example.demo.model.Studente;
public class StudenteDTO {

	private Integer id;
	
	private LocalDate dataIscrizione;
	
	private Integer idCorso;
	
	private Integer idStatoPagamento;
	
	private Integer idAnagrafica;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataIscrizione() {
		return dataIscrizione;
	}

	public void setDataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}

	public Integer getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(Integer idCorso) {
		this.idCorso = idCorso;
	}

	public Integer getIdStatoPagamento() {
		return idStatoPagamento;
	}

	public void setIdStatoPagamento(Integer idStatoPagamento) {
		this.idStatoPagamento = idStatoPagamento;
	}

	public Integer getIdAnagrafica() {
		return idAnagrafica;
	}

	public void setIdAnagrafica(Integer idAnagrafica) {
		this.idAnagrafica = idAnagrafica;
	}

	public StudenteDTO() {
		super();
	}
	
	public static StudenteDTO cambiaTipoToDto (Studente studente) {
		StudenteDTO studenteDto = new StudenteDTO();
		studenteDto.setId(studente.getId());
		studenteDto.setDataIscrizione(studente.getDataIscrizione());
		studenteDto.setIdStatoPagamento(studente.getStatoPagamento().getId());
		studenteDto.setIdAnagrafica(studente.getAnagrafica().getId());
		studenteDto.setIdCorso(studente.getCorso().getId());
		return studenteDto;
		}
	
	public static Studente cambiaTipoFromDto (StudenteDTO studenteDto) {
		Studente studente = new Studente();		
		studente.setId(studenteDto.getId());
		studente.setDataIscrizione(studenteDto.getDataIscrizione());	
		return studente;
		}
	
	
}
