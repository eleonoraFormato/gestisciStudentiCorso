package com.example.demo.controller.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Utente;
import com.example.demo.model.service.SrvAnagrafica;


public class UtenteDTO {

	private Integer id;
	
	private String eMail;
	
	private String password;
	
	private String tipoUtente;
	
	private Integer idAnagrafica;
	
	@Autowired
	SrvAnagrafica srvAnagrafica;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUtente() {
		return tipoUtente;
	}

	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}

	public Integer getIdAnagrafica() {
		return idAnagrafica;
	}

	public void setIdAnagrafica(Integer idAnagrafica) {
		this.idAnagrafica = idAnagrafica;
	}

	public UtenteDTO() {
		super();
	}
	
	public static UtenteDTO cambiaTipoToDto (Utente utente) {
		UtenteDTO utenteDto = new UtenteDTO();
		utenteDto.setId(utente.getId());
		utenteDto.seteMail(utente.geteMail());
		utenteDto.setPassword(utente.getPassword());
		utenteDto.setTipoUtente(utente.getTipoUtente());
		utenteDto.setIdAnagrafica(utente.getAnagrafica().getId());
		return utenteDto;
		}
	
	public static Utente cambiaTipoFromDto (UtenteDTO utenteDto) {
		
		Utente utente = new Utente();
		utente.setId(utenteDto.getId());
		utente.seteMail(utenteDto.geteMail());
		utente.setPassword(utenteDto.getPassword());
		utente.setTipoUtente(utenteDto.getTipoUtente());
		return utente;
		}
}
