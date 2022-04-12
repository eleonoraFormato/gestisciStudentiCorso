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
import com.example.demo.controller.response.ResponseUtente;
import com.example.demo.model.Utente;
import com.example.demo.model.repository.RepUtente;
import com.example.demo.model.service.SrvUtente;

@RestController
@RequestMapping ("/utente")
public class UtenteController {
	@Autowired
	SrvUtente srvUtente;
	@Autowired
	RepUtente repUtente;
	UtenteDTO utenteDto = new UtenteDTO();
	ResponseUtente response = new ResponseUtente();
	
	@PostMapping("/save")
	public @ResponseBody ResponseUtente save (@RequestBody UtenteDTO utenteDto) {
		try {
			response = srvUtente.create(utenteDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	
	@GetMapping("/get/{id}")
	public @ResponseBody ResponseUtente get (@PathVariable Integer id) {
		try {
			if (repUtente.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				response.setUtenteDTO(utenteDto.cambiaTipoToDto(srvUtente.findById(id)));
			} else {

				response.setMsg("Non esiste un'utente correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseUtente delete (@PathVariable Integer id) {
		try {
			if (repUtente.existsById(id)) {
				response.setUtenteDTO(utenteDto.cambiaTipoToDto(srvUtente.findById(id)));
	 			response.setMsg(srvUtente.delete(id));
			}
			else {

				response.setMsg("Non esiste un'utente correlata all'id selezionato, riprova!");
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setUtenteDTO(null);

		}
		return response;

	}
	@GetMapping("/get")
	public @ResponseBody List<UtenteDTO>  getAll () {
		
		List<UtenteDTO> lista = new ArrayList<>();
		try {
			
			
			for (Utente a:srvUtente.findAll())
				lista.add(utenteDto.cambiaTipoToDto(a));	
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return lista;
	}
}
