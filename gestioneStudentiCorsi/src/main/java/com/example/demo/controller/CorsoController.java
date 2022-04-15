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
import com.example.demo.model.service.SrvCorso;

@RestController
@RequestMapping ("/corso")
public class CorsoController {
	@Autowired
	SrvCorso srvCorso;
	
	
	
	@PostMapping("/save")
	public   @ResponseBody Response<CorsoDTO> save (@RequestBody CorsoDTO corsoDto) {
		Response<CorsoDTO> response= new Response<>();
		try {
			response = srvCorso.create(corsoDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	@GetMapping("/get/{id}")
	public @ResponseBody Response<CorsoDTO> get (@PathVariable Integer id) {
		Response<CorsoDTO> response= new Response<>();

		try {
			if (srvCorso.existsById(id)) {
				response.setMsg("A questo id corrisponde questo  ");
				response.setData(CorsoDTO.cambiaTipoToDto(srvCorso.findById(id)));

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
		Response<CorsoDTO> response= new Response<>();
		try {
			if (srvCorso.existsById(id)) {
				response.setData(CorsoDTO.cambiaTipoToDto(srvCorso.findById(id)));
	 			response.setMsg(srvCorso.delete(id));
			}
			else {
				response.setMsg("Non esiste un corso correlato all'id selezionato, riprova!");
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
	public @ResponseBody Response<List<CorsoDTO>>  getAll () {
		Response<List<CorsoDTO>> response= new Response<>();
		List<CorsoDTO>lista = new ArrayList<>();
		try {
			
			for (Corso a:srvCorso.findAll())
				lista.add(CorsoDTO.cambiaTipoToDto(a));	
			response.setData(lista);
			response.setMsg("Ecco tutte i Corsi!");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}
}
