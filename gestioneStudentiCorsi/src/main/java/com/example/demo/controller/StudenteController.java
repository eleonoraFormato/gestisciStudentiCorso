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

import com.example.demo.controller.dto.StudenteDTO;
import com.example.demo.controller.response.ResponseStudente;
import com.example.demo.model.Studente;
import com.example.demo.model.repository.RepStudente;
import com.example.demo.model.service.SrvStudente;

@RestController
@RequestMapping ("/studente")
public class StudenteController {
	@Autowired
	SrvStudente srvStudente;
	@Autowired
	RepStudente repStudente;
	StudenteDTO studenteDto = new StudenteDTO();
	ResponseStudente response = new ResponseStudente();
	
	@PostMapping("/save")
	public @ResponseBody ResponseStudente save (@RequestBody StudenteDTO studenteDto) {
		try {
			response = srvStudente.create(studenteDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	@GetMapping("/get/{id}")
	public @ResponseBody ResponseStudente get (@PathVariable Integer id) {
		
		try {
			if (repStudente.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				response.setStudenteDTO(studenteDto.cambiaTipoToDto(srvStudente.findById(id)));
			} else {

				response.setMsg("Non esiste un'studente correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseStudente delete (@PathVariable Integer id) {
		try {
			if (repStudente.existsById(id)) {
				response.setStudenteDTO(studenteDto.cambiaTipoToDto(srvStudente.findById(id)));
	 			response.setMsg(srvStudente.delete(id));
			}
			else {

				response.setMsg("Non esiste un'studente correlata all'id selezionato, riprova!");
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setStudenteDTO(null);

		}
		return response;
	}
	@GetMapping("/get")
	public @ResponseBody List<StudenteDTO>  getAll () {

		List<StudenteDTO> lista = new ArrayList<>();
		try {
			
			
			for (Studente a:srvStudente.findAll())
				lista.add(studenteDto.cambiaTipoToDto(a));	
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return lista;
	}
}
