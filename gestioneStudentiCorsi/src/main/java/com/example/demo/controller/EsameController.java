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

import com.example.demo.controller.dto.EsameDTO;
import com.example.demo.controller.response.ResponseEsame;
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
	ResponseEsame response = new ResponseEsame();
	
	@PostMapping("/save")
	public @ResponseBody ResponseEsame save (@RequestBody EsameDTO esameDto) {
		try {
			response = srvEsame.create(esameDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	@GetMapping("/get/{id}")
	public @ResponseBody ResponseEsame get (@PathVariable Integer id) {
		
		try {
			if (repEsame.existsById(id)) {
				response.setMsg("A questo id corrisponde questo  ");
				response.setEsameDTO(esameDto.cambiaTipoToDto(srvEsame.findById(id)));
			} else {

				response.setMsg("Non esiste un esame correlato all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public  @ResponseBody ResponseEsame delete (@PathVariable Integer id) {
		try {
			if (repEsame.existsById(id)) {
				response.setEsameDTO(esameDto.cambiaTipoToDto(srvEsame.findById(id)));
	 			response.setMsg(srvEsame.delete(id));
			}
			else {
				response.setMsg("Non esiste un esame correlato all'id selezionato, riprova!");
				response.setEsameDTO(null);
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setEsameDTO(null);

		}
		return response;

	}
	@GetMapping("/get")
	public @ResponseBody List<EsameDTO>  getAll () {
		
		List<EsameDTO> lista = new ArrayList<>();
		try {
			
			for (Esame a:srvEsame.findAll())
				lista.add(esameDto.cambiaTipoToDto(a));	
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return lista;
	}
}
