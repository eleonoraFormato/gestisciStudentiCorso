package com.example.demo.model.service;

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
	
	Response<MateriaDTO> response;
	List<MateriaDTO> lista;


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
		try {
		Materia materia = materiaDto.cambiaTipoFromDto(materiaDto);
		lista = response.aggiungi(materiaDto.cambiaTipoToDto(this.repMateria.save(materia)));
		response.setLista(lista);
		response.setMsg("Caricamento Materia riuscito con successo!");
		}
		catch(Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setLista(null);
		}
		
		return response;
	}
}

