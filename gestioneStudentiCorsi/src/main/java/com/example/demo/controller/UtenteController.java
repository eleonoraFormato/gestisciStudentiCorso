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


import com.example.demo.controller.dto.UtenteDTO;
import com.example.demo.model.Utente;
import com.example.demo.model.service.SrvUtente;

@RestController
@RequestMapping ("/utente")
public class UtenteController {
	@Autowired
	SrvUtente srvUtente;
	
	@PostMapping("/save")
	public @ResponseBody Response<UtenteDTO> save (@RequestBody UtenteDTO utenteDto) {
		Response<UtenteDTO> response= new Response<>();
		try {
			response = srvUtente.create(utenteDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	
	@GetMapping("/get/{id}")
	public @ResponseBody Response<UtenteDTO> get (@PathVariable Integer id) {
		Response<UtenteDTO> response= new Response<>();
		try {
			if (srvUtente.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				response.setData(UtenteDTO.cambiaTipoToDto(srvUtente.findById(id)));
			} else {

				response.setMsg("Non esiste un'utente correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody Response<UtenteDTO> delete (@PathVariable Integer id) {
		Response<UtenteDTO> response= new Response<>();
		try {
			if (srvUtente.existsById(id)) {
				response.setData(UtenteDTO.cambiaTipoToDto(srvUtente.findById(id)));
	 			response.setMsg(srvUtente.delete(id));
			}
			else {

				response.setMsg("Non esiste un'utente correlata all'id selezionato, riprova!");
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
	public @ResponseBody Response<List<UtenteDTO>>  getAll () {
		Response<List<UtenteDTO>> response= new Response<>();
		List <UtenteDTO> lista = new ArrayList<>();
		try {
			
			for (Utente a:srvUtente.findAll())
				lista.add(UtenteDTO.cambiaTipoToDto(a));
			response.setData(lista);
			response.setMsg("Ecco una lista di tutti gli Utenti! ");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}
}
