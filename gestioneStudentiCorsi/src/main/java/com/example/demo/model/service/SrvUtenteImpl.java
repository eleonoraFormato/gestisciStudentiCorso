package com.example.demo.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Response;
import com.example.demo.controller.dto.UtenteDTO;
import com.example.demo.model.Utente;
import com.example.demo.model.repository.RepUtente;

@Service
public class SrvUtenteImpl implements SrvUtente {
	@Autowired
	RepUtente repUtente;
	@Autowired
	SrvAnagrafica srvAnagrafica;
	
	Response<UtenteDTO> response;
	List<UtenteDTO>lista;
	
	@Override
	public Utente findById(Integer id) {

		return this.repUtente.findById(id).get();

	}

	@Override
	public String delete(Integer id) {

		String esito;
		if (this.repUtente.existsById(id)) {
			this.repUtente.deleteById(id);
			esito = "eliminazione avvenuta con successo";
		}

		else {
			esito = "id inserito non esistente, eliminazione non riuscita";
		}

		return esito;
	}

	@Override
	public Utente findByeMailAndPassword(String eMail, String password) {

		return this.repUtente.findByeMailAndPassword(eMail, password).get();
	}

	@Override
	public List<Utente> findAll() {

		return this.repUtente.findAll();
	}

	@Override
	public Response<UtenteDTO>create(UtenteDTO utenteDto) {
		try {
			Utente utente = utenteDto.cambiaTipoFromDto(utenteDto);
			utente.setId(utenteDto.getId());
			utente.setAnagrafica(this.srvAnagrafica.findById(utenteDto.getIdAnagrafica()));
			lista = response.aggiungi(utenteDto.cambiaTipoToDto(this.repUtente.save(utente)));
			response.setLista(lista);
			response.setMsg("Caricamento Utente riuscito con successo!");
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setLista(null);
		}

		return response;
	}
}
