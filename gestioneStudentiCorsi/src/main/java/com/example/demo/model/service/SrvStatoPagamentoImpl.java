package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.StatoPagamentoDTO;
import com.example.demo.controller.response.ResponseStatoPagamento;
import com.example.demo.model.StatoPagamento;
import com.example.demo.model.repository.RepStatoPagamento;

@Service
public class SrvStatoPagamentoImpl implements SrvStatoPagamento {
	@Autowired
	RepStatoPagamento repStatoPagamento;

	@Override
	public ResponseStatoPagamento create(StatoPagamentoDTO statoPagamentoDto) {
		
		ResponseStatoPagamento response = new ResponseStatoPagamento();
		try {
		StatoPagamento statoPagamento = statoPagamentoDto.cambiaTipoFromDto(statoPagamentoDto);
		response.setStatoPagamentoDTO(statoPagamentoDto.cambiaTipoToDto(this.repStatoPagamento.save(statoPagamento)));
		response.setMsg("Caricamento Stato Pagamento riuscito con successo!");
		}
		catch(Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setStatoPagamentoDTO(null);
		}
		
		return response;
	}

	@Override
	public StatoPagamento findById(Integer id) {
	
		return this.repStatoPagamento.findById(id).get();
	}
	@Override
	public String delete(Integer id) {
		String esito;
		if (this.repStatoPagamento.existsById(id))
			{
				this.repStatoPagamento.deleteById(id);
				esito = "eliminazione avvenuta con successo";
			}
		
		else {
			esito ="id inserito non esistente, eliminazione non riuscita";
		}
		
		return esito;
		
	}

	@Override
	public List<StatoPagamento> findAll() {
		return this.repStatoPagamento.findAll();
	}
	
}
