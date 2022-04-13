package com.example.demo.controller;

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

import com.example.demo.controller.dto.MateriaDTO;
import com.example.demo.model.Materia;
import com.example.demo.model.repository.RepMateria;
import com.example.demo.model.service.SrvMateria;

@RestController
@RequestMapping ("/materia")
public class MateriaController {
	@Autowired
	SrvMateria srvMateria;
	@Autowired
	RepMateria repMateria;
	MateriaDTO materiaDto = new MateriaDTO();
	Response<MateriaDTO> response;
	List<MateriaDTO> lista;
	
	@PostMapping("/save")
	public @ResponseBody Response<MateriaDTO> save (@RequestBody MateriaDTO materiaDto) {
		try {
			response = srvMateria.create(materiaDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	@GetMapping("/get/{id}")
	public @ResponseBody Response<MateriaDTO> get (@PathVariable Integer id) {
		
		try {
			if (repMateria.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				lista = response.aggiungi(materiaDto.cambiaTipoToDto(srvMateria.findById(id)));
				response.setLista(lista);

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
		try {
			if (repMateria.existsById(id)) {
			lista = response.aggiungi(materiaDto.cambiaTipoToDto(srvMateria.findById(id)));
			response.setLista(lista);
	 			response.setMsg(srvMateria.delete(id));
			}
			else {
				response.setMsg("Non esiste una materia correlata all'id selezionato, riprova!");
				response.setLista(null);
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setLista(null);

		}
		return response;

	}
	@GetMapping("/get")
	public @ResponseBody Response<MateriaDTO>  getAll () {
		
		try {
			
			for (Materia a:srvMateria.findAll())
				lista.add(materiaDto.cambiaTipoToDto(a));
			response.setLista(lista);
			response.setMsg("Ecco la lista di tutte le Materie! ");
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;
	}
}
