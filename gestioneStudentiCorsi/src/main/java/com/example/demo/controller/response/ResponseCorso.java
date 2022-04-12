package com.example.demo.controller.response;

//import java.util.ArrayList;
//import java.util.List;

import com.example.demo.controller.dto.CorsoDTO;

public class ResponseCorso {
	private String msg;
	private CorsoDTO corso;
	
	public String getMsg() {
		return msg;
	}
	public CorsoDTO getCorso() {
		return corso;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setCorsoDTO(CorsoDTO corso) {
		this.corso = corso;
	}
	public ResponseCorso() {
		super();
	}
	public ResponseCorso(String msg, CorsoDTO corso) {
		super();
		this.msg = msg;
		this.corso = corso;
	}
	
}
