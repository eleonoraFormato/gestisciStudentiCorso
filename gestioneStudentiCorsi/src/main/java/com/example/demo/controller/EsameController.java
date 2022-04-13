package com.example.demo.controller;


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

import com.example.demo.controller.dto.EsameDTO;
import com.example.demo.model.Esame;
import com.example.demo.model.repository.RepEsame;
import com.example.demo.model.service.SrvEsame;

@RestController
@RequestMapping ("/esame")
public class EsameController {
	@Autowired
	SrvEsame srvEsame;
	@Autowired
	RepEsame repEsame;
	EsameDTO esameDto = new EsameDTO();
	Response<EsameDTO> response;
	List<EsameDTO> lista;
	
	@PostMapping("/save")
	public @ResponseBody Response<EsameDTO> save (@RequestBody EsameDTO esameDto) {
		try {
			response = srvEsame.create(esameDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	@GetMapping("/get/{id}")
	public @ResponseBody Response<EsameDTO> get (@PathVariable Integer id) {
		
		try {
			if (repEsame.existsById(id)) {
				response.setMsg("A questo id corrisponde questo  ");
				lista = response.aggiungi(esameDto.cambiaTipoToDto(srvEsame.findById(id)));
				response.setLista(lista);
			} else {

				response.setMsg("Non esiste un esame correlato all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public  @ResponseBody Response<EsameDTO> delete (@PathVariable Integer id) {
		try {
			if (repEsame.existsById(id)) {
				lista = response.aggiungi(esameDto.cambiaTipoToDto(srvEsame.findById(id)));
				response.setLista(lista);
	 			response.setMsg(srvEsame.delete(id));
			}
			else {
				response.setMsg("Non esiste un esame correlato all'id selezionato, riprova!");
				response.setLista(null);
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setLista(null);

		}
		return response;

	}
	@GetMapping("/get")
	public @ResponseBody Response<EsameDTO> getAll () {
		
		try {
			
			for (Esame a:srvEsame.findAll())
				lista.add(esameDto.cambiaTipoToDto(a));
			response.setLista(lista);
			response.setMsg("Ecco la lista di tutti gli esami!");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}
}
