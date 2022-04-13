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

import com.example.demo.controller.dto.CorsoDTO;
import com.example.demo.model.Corso;
import com.example.demo.model.repository.RepCorso;
import com.example.demo.model.service.SrvCorso;

@RestController
@RequestMapping ("/corso")
public class CorsoController {
	@Autowired
	SrvCorso srvCorso;
	@Autowired
	RepCorso repCorso;
	CorsoDTO corsoDto = new CorsoDTO();
	Response<CorsoDTO> response= new Response<>();
	List<CorsoDTO> lista= new ArrayList<>();
	
	@PostMapping("/save")
	public   @ResponseBody Response<CorsoDTO> save (@RequestBody CorsoDTO corsoDto) {
		try {
			response = srvCorso.create(corsoDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	@GetMapping("/get/{id}")
	public @ResponseBody Response<CorsoDTO> get (@PathVariable Integer id) {

		try {
			if (repCorso.existsById(id)) {
				response.setMsg("A questo id corrisponde questo  ");
				lista = response.aggiungi(corsoDto.cambiaTipoToDto(srvCorso.findById(id)));
				response.setLista(lista);

			} else {

				response.setMsg("Non esiste un corso correlato all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
		
	
	@DeleteMapping("/delete/{id}")
	public  @ResponseBody Response<CorsoDTO> delete (@PathVariable Integer id) {
		try {
			if (repCorso.existsById(id)) {
				lista = response.aggiungi(corsoDto.cambiaTipoToDto(srvCorso.findById(id)));
				response.setLista(lista);
	 			response.setMsg(srvCorso.delete(id));
			}
			else {
				response.setMsg("Non esiste un corso correlato all'id selezionato, riprova!");
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
	public @ResponseBody Response<CorsoDTO>  getAll () {
		try {
			
			for (Corso a:srvCorso.findAll())
				lista.add(corsoDto.cambiaTipoToDto(a));	
			response.setLista(lista);
			response.setMsg("Ecco tutte i Corsi!");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}
}
