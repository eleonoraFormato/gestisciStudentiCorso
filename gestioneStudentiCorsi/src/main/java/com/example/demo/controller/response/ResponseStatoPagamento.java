package com.example.demo.controller.response;

//import java.util.ArrayList;
//import java.util.List;

import com.example.demo.controller.dto.StatoPagamentoDTO;

public class ResponseStatoPagamento {
	private String msg;
	private StatoPagamentoDTO statoPagamento;
	
	public String getMsg() {
		return msg;
	}
	public StatoPagamentoDTO getStatoPagamento() {
		return statoPagamento;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setStatoPagamentoDTO(StatoPagamentoDTO statoPagamento) {
		this.statoPagamento = statoPagamento;
	}
	public ResponseStatoPagamento() {
		super();
	}
	public ResponseStatoPagamento(String msg, StatoPagamentoDTO statoPagamento) {
		super();
		this.msg = msg;
		this.statoPagamento = statoPagamento;
	}
	
}
