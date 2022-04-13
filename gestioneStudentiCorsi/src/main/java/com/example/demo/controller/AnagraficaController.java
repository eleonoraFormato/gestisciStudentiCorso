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

import com.example.demo.controller.dto.AnagraficaDTO;
import com.example.demo.controller.Response;
import com.example.demo.model.Anagrafica;
import com.example.demo.model.repository.RepAnagrafica;
import com.example.demo.model.service.SrvAnagrafica;

@RestController
@RequestMapping("/anagrafica")
public class AnagraficaController {
	@Autowired
	SrvAnagrafica srvAnagrafica;

	@Autowired
	RepAnagrafica repAnagrafica;
	AnagraficaDTO anagraficaDto = new AnagraficaDTO();
	Response<AnagraficaDTO> response= new Response<>();
	List<AnagraficaDTO> lista= new ArrayList<>();
	
	@PostMapping("/save")
	public @ResponseBody Response<AnagraficaDTO> save(@RequestBody AnagraficaDTO anagraficaDto) {

		try {
			response = srvAnagrafica.create(anagraficaDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}

	@GetMapping("/get/{id}")
	public @ResponseBody Response<AnagraficaDTO> get(@PathVariable Integer id) {

		try {
			if (repAnagrafica.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				lista = response.aggiungi(anagraficaDto.cambiaTipoToDto(srvAnagrafica.findById(id)));
				response.setLista(lista);
			} else {

				response.setMsg("Non esiste un'anagrafica correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}

	@GetMapping("/get")
	public @ResponseBody Response<AnagraficaDTO> getAll() {
		try {
			
			
			for (Anagrafica a:srvAnagrafica.findAll())
				lista.add(anagraficaDto.cambiaTipoToDto(a));
			response.setLista(lista);
			response.setMsg("Ecco tutte le anagrafiche! ");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody Response<AnagraficaDTO> delete(@PathVariable Integer id) {
		try {
			if (repAnagrafica.existsById(id)) {
				lista = response.aggiungi(anagraficaDto.cambiaTipoToDto(srvAnagrafica.findById(id)));
				response.setLista(lista);
	 			response.setMsg(srvAnagrafica.delete(id));
			}
			else {

				response.setMsg("Non esiste un'anagrafica correlata all'id selezionato, riprova!");
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setLista(null);

		}
		return response; 

	}

}
