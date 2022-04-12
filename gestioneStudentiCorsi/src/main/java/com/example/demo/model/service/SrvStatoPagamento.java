package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.StatoPagamentoDTO;
import com.example.demo.controller.response.ResponseStatoPagamento;
import com.example.demo.model.StatoPagamento;

@Service
public interface SrvStatoPagamento {
	public ResponseStatoPagamento create(StatoPagamentoDTO statoPagamentoDto);
	public StatoPagamento findById(Integer id);
	
	public String delete (Integer id);
	public List<StatoPagamento> findAll();
}
