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
import com.example.demo.controller.dto.StudenteDTO;
import com.example.demo.model.Studente;
import com.example.demo.model.service.SrvStudente;

@RestController
@RequestMapping ("/studente")
public class StudenteController {
	@Autowired
	SrvStudente srvStudente;
	
	
	@PostMapping("/save")
	public @ResponseBody Response<StudenteDTO> save (@RequestBody StudenteDTO studenteDto) {
		Response<StudenteDTO> response= new Response<>();
		try {
			response = srvStudente.create(studenteDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	@PostMapping("/get/{id}")
	public @ResponseBody Response<StudenteDTO> get (@PathVariable Integer id) {
		Response<StudenteDTO> response= new Response<>();		
		try {
			if (srvStudente.existsById(id)) {
				response.setMsg("A questo id corrisponde questa");
				response.setData(StudenteDTO.cambiaTipoToDto(srvStudente.findById(id)));
			} else {

				response.setMsg("Non esiste un'studente correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody Response<StudenteDTO> delete (@PathVariable Integer id) {
		Response<StudenteDTO> response= new Response<>();
		try {
			if (srvStudente.existsById(id)) {
				response.setData(StudenteDTO.cambiaTipoToDto(srvStudente.findById(id)));
	 			response.setMsg(srvStudente.delete(id));
			}
			else {

				response.setMsg("Non esiste un'studente correlata all'id selezionato, riprova!");
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
	public @ResponseBody Response<List<StudenteDTO>>  getAll () {
		Response<List<StudenteDTO>> response= new Response<>();
		List<StudenteDTO> lista = new ArrayList<>();
		try {
			
			
			for (Studente a:srvStudente.findAll())
				lista.add(StudenteDTO.cambiaTipoToDto(a));
			response.setData(lista);
			response.setMsg("Ecco una lista con tutti gli Studenti! ");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}
	@PostMapping("/search")
	public @ResponseBody Response <List<StudenteDTO>> getBy (@RequestParam String parametro) {
		Response <List<StudenteDTO>> response= new Response<>();
		
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
