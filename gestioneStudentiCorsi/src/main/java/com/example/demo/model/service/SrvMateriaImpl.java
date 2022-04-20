package com.example.demo.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Response;
import com.example.demo.controller.dto.MateriaDTO;
import com.example.demo.model.Materia;
import com.example.demo.model.repository.RepMateria;

@Service
public class SrvMateriaImpl implements SrvMateria {
	@Autowired
	RepMateria repMateria;

	@Override
	public Materia findById(Integer id) {
		
		return this.repMateria.findById(id).get();
	}

	@Override
	public String delete(Integer id) {
		String esito;
		if (this.repMateria.existsById(id))
			{
				this.repMateria.deleteById(id);
				esito = "eliminazione avvenuta con successo";
			}
		
		else {
			esito ="id inserito non esistente, eliminazione non riuscita";
		}
		
		return esito;
		
	}

	@Override
	public List<Materia> findAll() {
		return this.repMateria.findAll();
	}

	@Override
	public Response<MateriaDTO> create(MateriaDTO materiaDto) {
		Response<MateriaDTO> response = new Response <>();
		try {
		response.setData(MateriaDTO.cambiaTipoToDto(this.repMateria.save(MateriaDTO.cambiaTipoFromDto(materiaDto))));
		response.setMsg("Caricamento Materia riuscito con successo!");
		}
		catch(Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setData(null);
		}
		
		return response;
	}

	@Override
	public Boolean existsById(Integer id) {
		return this.repMateria.existsById(id);
	}

	@Override
	public List<MateriaDTO> findBy(String parametro, String valore) {
		List <MateriaDTO> lista = new ArrayList<>();
		 for (Materia m: this.repMateria.findBy(parametro, valore))
			lista.add(MateriaDTO.cambiaTipoToDto(m));
		 this.repMateria.findBy(parametro, valore);
		return lista;
	}
}

