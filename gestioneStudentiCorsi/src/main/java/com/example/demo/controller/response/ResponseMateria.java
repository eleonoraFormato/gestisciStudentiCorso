package com.example.demo.controller.response;

//import java.util.ArrayList;
//import java.util.List;

import com.example.demo.controller.dto.MateriaDTO;

public class ResponseMateria {
	private String msg;
	private MateriaDTO materia;
	
	public String getMsg() {
		return msg;
	}
	public MateriaDTO getMateria() {
		return materia;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setMateriaDTO(MateriaDTO materia) {
		this.materia = materia;
	}
	public ResponseMateria() {
		super();
	}
	public ResponseMateria(String msg, MateriaDTO materia) {
		super();
		this.msg = msg;
		this.materia = materia;
	}
	
}
