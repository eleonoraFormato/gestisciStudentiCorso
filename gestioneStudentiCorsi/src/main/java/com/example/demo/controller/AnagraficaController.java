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
import com.example.demo.model.Anagrafica;
import com.example.demo.model.service.SrvAnagrafica;

@RestController
@RequestMapping("/anagrafica")
public class AnagraficaController {
	@Autowired
	SrvAnagrafica srvAnagrafica;

	
	
	
	@PostMapping("/save")
	public @ResponseBody Response<AnagraficaDTO> save(@RequestBody AnagraficaDTO anagraficaDto) {
		Response<AnagraficaDTO> response= new Response<>();
		try {
			response = srvAnagrafica.create(anagraficaDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}

	@GetMapping("/get/{id}")
	public @ResponseBody Response<AnagraficaDTO> get(@PathVariable Integer id) {
		Response<AnagraficaDTO> response= new Response<>();
		try {
			if (srvAnagrafica.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				response.setData(AnagraficaDTO.cambiaTipoToDto(srvAnagrafica.findById(id)));
			} else {

				response.setMsg("Non esiste un'anagrafica correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}

	@GetMapping("/get")
	public @ResponseBody Response<List<AnagraficaDTO>> getAll() {
		Response<List<AnagraficaDTO>> response= new Response<>();
		List<AnagraficaDTO> lista = new ArrayList<>();
		try {
			
			for (Anagrafica a:srvAnagrafica.findAll())
				lista.add(AnagraficaDTO.cambiaTipoToDto(a));
			response.setData(lista);
			response.setMsg("Ecco tutte le anagrafiche! ");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody Response<AnagraficaDTO> delete(@PathVariable Integer id) {
		Response<AnagraficaDTO> response= new Response<>();
		try {
			if (srvAnagrafica.existsById(id)) {
				response.setData(AnagraficaDTO.cambiaTipoToDto(srvAnagrafica.findById(id)));
	 			response.setMsg(srvAnagrafica.delete(id));
			}
			else {

				response.setMsg("Non esiste un'anagrafica correlata all'id selezionato, riprova!");
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());

		}
		return response; 

	}

}
