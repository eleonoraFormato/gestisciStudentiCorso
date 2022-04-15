package com.example.demo.controller.dto;

import com.example.demo.model.StatoPagamento;

public class StatoPagamentoDTO {
	
	private Integer id;
	
	private String descrizione;
	
	private String codicePagamento;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodicePagamento() {
		return codicePagamento;
	}

	public void setCodicePagamento(String codicePagamento) {
		this.codicePagamento = codicePagamento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	public StatoPagamentoDTO() {
		super();
	}

	public static StatoPagamentoDTO cambiaTipoToDto (StatoPagamento statoPagamento) {
		
		StatoPagamentoDTO statoPagamentoDTO = new StatoPagamentoDTO();
		statoPagamentoDTO.setId(statoPagamento.getId());	
		statoPagamentoDTO.setDescrizione(statoPagamento.getDescrizione());
		statoPagamentoDTO.setCodicePagamento(statoPagamento.getCodicePagamento());
		return statoPagamentoDTO;
	}
	
	public static StatoPagamento cambiaTipoFromDto (StatoPagamentoDTO statoPagamentoDTO) {
		
		StatoPagamento statoPagamento = new StatoPagamento();
		statoPagamento.setId(statoPagamentoDTO.getId());	
		statoPagamento.setDescrizione(statoPagamentoDTO.getDescrizione());
		statoPagamento.setCodicePagamento(statoPagamentoDTO.getCodicePagamento());
		return statoPagamento;
	}
}
