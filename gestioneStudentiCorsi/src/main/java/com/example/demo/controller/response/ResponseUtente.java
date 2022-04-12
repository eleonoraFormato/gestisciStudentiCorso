package com.example.demo.controller.response;

//import java.util.ArrayList;
//import java.util.List;

import com.example.demo.controller.dto.UtenteDTO;

public class ResponseUtente {
	private String msg;
	private UtenteDTO utente;
	
	public String getMsg() {
		return msg;
	}
	public UtenteDTO getUtente() {
		return utente;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setUtenteDTO(UtenteDTO utente) {
		this.utente = utente;
	}
	public ResponseUtente() {
		super();
	}
	public ResponseUtente(String msg, UtenteDTO utente) {
		super();
		this.msg = msg;
		this.utente = utente;
	}
	
}
