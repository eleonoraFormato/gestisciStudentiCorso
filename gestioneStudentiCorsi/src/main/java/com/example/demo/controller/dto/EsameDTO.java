package com.example.demo.controller.dto;


import com.example.demo.model.Esame;


public class EsameDTO {
	private Integer id;
	private Integer voto;
	private Integer idStudente;
	private Integer idMateria;
	private Integer idCorso;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getVoto() {
		return voto;
	}


	public void setVoto(Integer voto) {
		this.voto = voto;
	}


	public Integer getIdStudente() {
		return idStudente;
	}


	public void setIdStudente(Integer idStudente) {
		this.idStudente = idStudente;
	}


	public Integer getIdMateria() {
		return idMateria;
	}


	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}


	public Integer getIdCorso() {
		return idCorso;
	}


	public void setIdCorso(Integer idCorso) {
		this.idCorso = idCorso;
	}
	
	public EsameDTO() {
		super();
	}


	public static EsameDTO cambiaTipoToDto (Esame esame) {
		EsameDTO esameDto = new EsameDTO();
		esameDto.setId(esame.getId());
		esameDto.setVoto(esame.getVoto());
		esameDto.setIdStudente(esame.getStudente().getId());
		esameDto.setIdMateria(esame.getMateria().getId());
		esameDto.setIdCorso(esame.getCorso().getId());
		return esameDto;
		}
	
	public static Esame cambiaTipoFromDto (EsameDTO esameDto) {
		Esame esame = new Esame ();
		esame.setId(esameDto.getId());
		esame.setVoto(esameDto.getVoto());
		
		return esame;
	}
}
