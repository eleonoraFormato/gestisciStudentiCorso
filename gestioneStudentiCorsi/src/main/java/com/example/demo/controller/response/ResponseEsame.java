package com.example.demo.controller.response;

//import java.util.ArrayList;
//import java.util.List;

import com.example.demo.controller.dto.EsameDTO;

public class ResponseEsame {
	private String msg;
	private EsameDTO esame;
	
	public String getMsg() {
		return msg;
	}
	public EsameDTO getEsame() {
		return esame;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setEsameDTO(EsameDTO esame) {
		this.esame = esame;
	}
	public ResponseEsame() {
		super();
	}
	public ResponseEsame(String msg, EsameDTO esame) {
		super();
		this.msg = msg;
		this.esame = esame;
	}
	
}
