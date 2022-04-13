package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.Response;
import com.example.demo.controller.dto.StatoPagamentoDTO;
import com.example.demo.model.StatoPagamento;

@Service
public interface SrvStatoPagamento {
	public Response<StatoPagamentoDTO> create(StatoPagamentoDTO statoPagamentoDto);
	public StatoPagamento findById(Integer id);
	
	public String delete (Integer id);
	public List<StatoPagamento> findAll();
}
