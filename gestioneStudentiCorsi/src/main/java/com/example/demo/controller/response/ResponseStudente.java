package com.example.demo.controller.response;

//import java.util.ArrayList;
//import java.util.List;

import com.example.demo.controller.dto.StudenteDTO;

public class ResponseStudente {
	private String msg;
	private StudenteDTO studente;
	
	public String getMsg() {
		return msg;
	}
	public StudenteDTO getStudente() {
		return studente;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setStudenteDTO(StudenteDTO studente) {
		this.studente = studente;
	}
	public ResponseStudente() {
		super();
	}
	public ResponseStudente(String msg, StudenteDTO studente) {
		super();
		this.msg = msg;
		this.studente = studente;
	}
	
}
