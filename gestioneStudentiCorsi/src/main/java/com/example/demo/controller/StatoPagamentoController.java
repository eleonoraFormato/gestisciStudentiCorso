package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.controller.dto.StatoPagamentoDTO;
import com.example.demo.model.StatoPagamento;
import com.example.demo.model.service.SrvStatoPagamento;

@RestController
@RequestMapping ("/statoPagamento")
public class StatoPagamentoController {
	@Autowired
	SrvStatoPagamento srvStatoPagamento;

	
	
	@PostMapping("/save")
	public @ResponseBody Response<StatoPagamentoDTO> save (@RequestBody StatoPagamentoDTO statoPagamentoDto) {
		Response<StatoPagamentoDTO> response= new Response<>();
		try {
			response = srvStatoPagamento.create(statoPagamentoDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	
	@GetMapping("/get/{id}")
	public @ResponseBody Response<StatoPagamentoDTO> get (@PathVariable Integer id) {
		Response<StatoPagamentoDTO> response= new Response<>();
		try {
			if (srvStatoPagamento.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				response.setData(StatoPagamentoDTO.cambiaTipoToDto(srvStatoPagamento.findById(id)));
			} else {

				response.setMsg("Non esiste un statoPagamento correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody Response<StatoPagamentoDTO> delete (@PathVariable Integer id) {
		Response<StatoPagamentoDTO> response= new Response<>();
		try {
			if (srvStatoPagamento.existsById(id)) {
				response.setData(StatoPagamentoDTO.cambiaTipoToDto(srvStatoPagamento.findById(id)));
	 			response.setMsg(srvStatoPagamento.delete(id));
			}
			else {
				response.setMsg("Non esiste una statoPagamento correlata all'id selezionato, riprova!");
				response.setData(null);
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setData(null);

		}
		return response;
	}
	@GetMapping("/get")
	public @ResponseBody Response <List<StatoPagamentoDTO>>  getAll () {
		Response <List<StatoPagamentoDTO>> response= new Response<>();
		List<StatoPagamentoDTO> lista= new ArrayList<>();
		try {
			
			for (StatoPagamento a:srvStatoPagamento.findAll())
				lista.add(StatoPagamentoDTO.cambiaTipoToDto(a));	
			response.setData(lista);
			response.setMsg("Ecco la lista di tutti gli StatiPagamento");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}
}
