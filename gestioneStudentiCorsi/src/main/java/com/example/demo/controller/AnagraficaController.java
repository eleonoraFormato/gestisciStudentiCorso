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
import com.example.demo.controller.response.ResponseAnagrafica;
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
	ResponseAnagrafica response = new ResponseAnagrafica();

	@PostMapping("/save")
	public @ResponseBody ResponseAnagrafica save(@RequestBody AnagraficaDTO anagraficaDto) {

		try {
			response = srvAnagrafica.create(anagraficaDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}

	@GetMapping("/get/{id}")
	public @ResponseBody ResponseAnagrafica get(@PathVariable Integer id) {

		try {
			if (repAnagrafica.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				response.setAnagraficaDTO(anagraficaDto.cambiaTipoToDto(srvAnagrafica.findById(id)));
			} else {

				response.setMsg("Non esiste un'anagrafica correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}

	@GetMapping("/get")
	public @ResponseBody List<AnagraficaDTO> getAll() {
		List<AnagraficaDTO> lista = new ArrayList<>();
		try {
			
			
			for (Anagrafica a:srvAnagrafica.findAll())
				lista.add(anagraficaDto.cambiaTipoToDto(a));	
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return lista;
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseAnagrafica delete(@PathVariable Integer id) {
		try {
			if (repAnagrafica.existsById(id)) {
				response.setAnagraficaDTO(anagraficaDto.cambiaTipoToDto(srvAnagrafica.findById(id)));
	 			response.setMsg(srvAnagrafica.delete(id));
			}
			else {

				response.setMsg("Non esiste un'anagrafica correlata all'id selezionato, riprova!");
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setAnagraficaDTO(null);

		}
		return response; 

	}

}
