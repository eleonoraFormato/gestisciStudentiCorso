package com.example.demo.controller.dto;

import com.example.demo.model.Materia;

public class MateriaDTO {
	private Integer id;

	private String nome;
	
	private String descrizione;
	
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
	
	
	
	public MateriaDTO() {
		super();
	}

	public static MateriaDTO cambiaTipoToDto (Materia materia) {
		
		MateriaDTO materiaDto = new MateriaDTO();
		materiaDto.setId(materia.getId());
		materiaDto.setNome(materia.getNome());
		materiaDto.setDescrizione(materia.getDescrizione());
		return materiaDto;
	}
	
	public static Materia cambiaTipoFromDto (MateriaDTO materiaDto) {
		
		Materia materia = new Materia();
		materia.setId(materiaDto.getId());
		materia.setNome(materiaDto.getNome());
		materia.setDescrizione(materiaDto.getDescrizione());
		return materia;
	}
}
