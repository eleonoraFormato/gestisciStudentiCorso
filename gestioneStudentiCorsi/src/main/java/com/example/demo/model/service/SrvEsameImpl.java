package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.EsameDTO;
import com.example.demo.controller.response.ResponseEsame;
import com.example.demo.model.Esame;
import com.example.demo.model.repository.RepEsame;

@Service
public class SrvEsameImpl implements SrvEsame {
	@Autowired
	RepEsame repEsame;
	@Autowired
	SrvCorso srvCorso;
	@Autowired
	SrvStudente srvStudente;
	@Autowired
	SrvMateria srvMateria;

	@Override
	public Esame findById(Integer id) {
		
		return this.repEsame.findById(id).get();
	}

	@Override
	public String delete(Integer id) {
		String esito;
		if (this.repEsame.existsById(id))
			{
				this.repEsame.deleteById(id);
				esito = "eliminazione avvenuta con successo";
			}
		
		else {
			esito ="id inserito non esistente, eliminazione non riuscita";
		}
		
		return esito;
		
	}

	@Override
	public List<Esame> findAll() {
		return this.repEsame.findAll();

	}

	@Override
	public ResponseEsame create(EsameDTO esameDto) {
		ResponseEsame response = new ResponseEsame();
		try {
			Esame esame = esameDto.cambiaTipoFromDto(esameDto);
			esame.setStudente(srvStudente.findById(esameDto.getIdStudente()));
			esame.setMateria(srvMateria.findById(esameDto.getId()));
			esame.setCorso(srvCorso.findById(esameDto.getId()));
			response.setEsameDTO(esameDto.cambiaTipoToDto(this.repEsame.save(esame)));
			response.setMsg("Caricamento Esame riuscito con successo!");
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setEsameDTO(null);
		}

		return response;
	}
}
