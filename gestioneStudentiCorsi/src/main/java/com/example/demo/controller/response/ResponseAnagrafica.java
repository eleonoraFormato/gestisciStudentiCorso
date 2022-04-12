package com.example.demo.controller.response;

//import java.util.ArrayList;
//import java.util.List;

import com.example.demo.controller.dto.AnagraficaDTO;

public class ResponseAnagrafica {
	private String msg;
	private List <T> lista;
	
	public String getMsg() {
		return msg;
	}
	public AnagraficaDTO getAnagrafica() {
		return anagrafica;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setAnagraficaDTO(AnagraficaDTO anagrafica) {
		this.anagrafica = anagrafica;
	}
	public ResponseAnagrafica() {
		super();
	}
	public ResponseAnagrafica(String msg, AnagraficaDTO anagrafica) {
		super();
		this.msg = msg;
		this.anagrafica = anagrafica;
	}
	
}
