package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.CorsoDTO;
import com.example.demo.controller.response.ResponseCorso;
import com.example.demo.model.Corso;
import com.example.demo.model.repository.RepCorso;

@Service
public class SrvCorsoImpl implements SrvCorso{
	@Autowired
	RepCorso repCorso;

	@Override
	public ResponseCorso create(CorsoDTO corsoDto) {
		ResponseCorso response = new ResponseCorso();
		try {
		Corso corso = corsoDto.cambiaTipoFromDto(corsoDto);
		response.setCorsoDTO(corsoDto.cambiaTipoToDto(this.repCorso.save(corso)));
		response.setMsg("Caricamento Anagrafica riuscito con successo!");
		}
		catch(Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setCorsoDTO(null);
		}
		
		return response;
	}

	@Override
	public Corso findById(Integer id) {
		
		return this.repCorso.findById(id).get();
	}

	@Override
	public String delete(Integer id) {
		String esito;
		if (this.repCorso.existsById(id))
			{
				this.repCorso.deleteById(id);
				esito = "eliminazione avvenuta con successo";
			}
		
		else {
			esito ="id inserito non esistente, eliminazione non riuscita";
		}
		
		return esito;
	}

	@Override
	public List<Corso> findAll() {
		return this.repCorso.findAll();
	}
}
