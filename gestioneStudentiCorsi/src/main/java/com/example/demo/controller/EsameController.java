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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.AnagraficaDTO;
import com.example.demo.controller.dto.EsameDTO;
import com.example.demo.model.Esame;
import com.example.demo.model.service.SrvEsame;

@RestController
@RequestMapping ("/esame")
public class EsameController {
	@Autowired
	SrvEsame srvEsame;
	
	
	@PostMapping("/save")
	public @ResponseBody Response<EsameDTO> save (@RequestBody EsameDTO esameDto) {
		Response<EsameDTO> response= new Response<>();
		try {
			response = srvEsame.create(esameDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	@PostMapping("/get/{id}")
	public @ResponseBody Response<EsameDTO> get (@PathVariable Integer id) {
		Response<EsameDTO> response= new Response<>();
		
		try {
			if (srvEsame.existsById(id)) {
				response.setMsg("A questo id corrisponde questo  ");
				response.setData(EsameDTO.cambiaTipoToDto(srvEsame.findById(id)));
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
		Response<EsameDTO> response= new Response<>();
		try {
			if (srvEsame.existsById(id)) {
				response.setData(EsameDTO.cambiaTipoToDto(srvEsame.findById(id)));
	 			response.setMsg(srvEsame.delete(id));
			}
			else {
				response.setMsg("Non esiste un esame correlato all'id selezionato, riprova!");
				response.setData(null);
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setData(null);

		}
		return response;

	}
	@PostMapping("/get")
	public @ResponseBody Response<List<EsameDTO>> getAll () {
		Response<List<EsameDTO>> response= new Response<>();
		List<EsameDTO> lista = new ArrayList<>();
		try {
			
			for (Esame a:srvEsame.findAll())
				lista.add(EsameDTO.cambiaTipoToDto(a));
			response.setData(lista);
			response.setMsg("Ecco la lista di tutti gli esami!");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}
	@PostMapping("/search")
	public @ResponseBody Response <List<EsameDTO>> getBy (@RequestParam String parametro) {
		Response <List<EsameDTO>> response= new Response<>();
		
		try {
				
				response.setMsg("Questo è quello che ho trovato!  " + parametro);
				//response.setData(srvMateria.findBy(parametro, Integer.parseInt(id)));

			} 
		 catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
}
