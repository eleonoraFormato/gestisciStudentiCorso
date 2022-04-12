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

import com.example.demo.controller.dto.MateriaDTO;
import com.example.demo.controller.response.ResponseMateria;
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
	ResponseMateria response = new ResponseMateria();
	
	@PostMapping("/save")
	public @ResponseBody ResponseMateria save (@RequestBody MateriaDTO materiaDto) {
		try {
			response = srvMateria.create(materiaDto);

		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return response;

	}
	@GetMapping("/get/{id}")
	public @ResponseBody ResponseMateria get (@PathVariable Integer id) {
		
		try {
			if (repMateria.existsById(id)) {
				response.setMsg("A questo id corrisponde questa  ");
				response.setMateriaDTO(materiaDto.cambiaTipoToDto(srvMateria.findById(id)));
			} else {

				response.setMsg("Non esiste un materia correlata all'id selezionato, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto: " + e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseMateria delete (@PathVariable Integer id) {
		try {
			if (repMateria.existsById(id)) {
				response.setMateriaDTO(materiaDto.cambiaTipoToDto(srvMateria.findById(id)));
	 			response.setMsg(srvMateria.delete(id));
			}
			else {
				response.setMsg("Non esiste una materia correlata all'id selezionato, riprova!");
				response.setMateriaDTO(null);
			}
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setMateriaDTO(null);

		}
		return response;

	}
	@GetMapping("/get")
	public @ResponseBody List<MateriaDTO>  getAll () {
		
		List<MateriaDTO> lista = new ArrayList<>();
		try {
			
			for (Materia a:srvMateria.findAll())
				lista.add(materiaDto.cambiaTipoToDto(a));	
		}
		catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
		}
		return lista;
	}
}
