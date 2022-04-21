package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.MateriaDTO;
import com.example.demo.model.Materia;
import com.example.demo.model.service.SrvMateria;

@RestController
@CrossOrigin(value = "*")
@RequestMapping ("/materia")
public class MateriaController {
	@Autowired
	SrvMateria srvMateria;
	@PostMapping("/save")
	public @ResponseBody Response<MateriaDTO> save (@RequestBody MateriaDTO materiaDto) {
		Response<MateriaDTO> response= new Response<>();
		try {
			response = srvMateria.create(materiaDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}

	@GetMapping("/get/{id}")
	public @ResponseBody Response<MateriaDTO> get (@PathVariable Integer id) {
		Response<MateriaDTO> response= new Response<>();
		
		try {
			if (srvMateria.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				response.setData(MateriaDTO.cambiaTipoToDto(srvMateria.findById(id)));

			} else {

				response.setMsg("Non esiste un materia correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody Response<MateriaDTO> delete (@PathVariable Integer id) {
		Response<MateriaDTO> response= new Response<>();
		try {
			if (srvMateria.existsById(id)) {
			response.setData(MateriaDTO.cambiaTipoToDto(srvMateria.findById(id)));
	 			response.setMsg(srvMateria.delete(id));
			}
			else {
				response.setMsg("Non esiste una materia correlata all'id selezionato, riprova!");
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
	public @ResponseBody Response<List<MateriaDTO>>  getAll () {
		Response<List<MateriaDTO>> response= new Response<>();
		List<MateriaDTO> lista = new ArrayList<>();
		try {
			
			for (Materia a:srvMateria.findAll())
				lista.add(MateriaDTO.cambiaTipoToDto(a));
			response.setData(lista);
			response.setMsg("Ecco la lista di tutte le Materie! ");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
		}

	
	//potrebbe esserci un metodo searchBy che prende in input due campi : la tabella e l'id e poi ti crea la query con i due dati (?)
	@GetMapping("/search")
	public @ResponseBody Response <List<MateriaDTO>> getBy (@RequestParam String parametro, @RequestParam String valore) {
		Response <List<MateriaDTO>> response= new Response<>();
		
		try {
				
				response.setMsg("Questo è quello che ho trovato!  " + srvMateria.findBy(parametro, valore).size() + valore);
//				response.setData(srvMateria.findBy(parametro));
				

			} 
		 catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}

}
