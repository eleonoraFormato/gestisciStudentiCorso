package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Response;
import com.example.demo.controller.dto.AnagraficaDTO;
import com.example.demo.model.Anagrafica;
import com.example.demo.model.repository.RepAnagrafica;

@Service
public class SrvAnagraficaImpl implements SrvAnagrafica {
	@Autowired
	RepAnagrafica repAnagrafica;

	@Override
	public Anagrafica findById(Integer id) {
		return this.repAnagrafica.findById(id).get();

	}

	@Override
	public Response<AnagraficaDTO> create(AnagraficaDTO anagraficaDto) {
		Response<AnagraficaDTO> response = new Response<>();
		try {
			if (anagraficaDto.getCodiceFiscale().length() == 16) {
				Anagrafica anagrafica = AnagraficaDTO.cambiaTipoFromDto(anagraficaDto);
				if (this.repAnagrafica.findByCodiceFiscale(anagraficaDto.getCodiceFiscale()) == null) {
					response.setData(AnagraficaDTO.cambiaTipoToDto(this.repAnagrafica.save(anagrafica)));
					response.setMsg("Caricamento Anagrafica riuscito con successo!");
				}

				else {
					response.setMsg("Caricamento non riuscito: Codice Fiscale già inserito!");
				}
			} else {
				response.setMsg("Codice Fiscale inserito non valido, riprova!");
			}
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());

		}
		return response;
	}

	@Override
	public String delete(Integer id) {
		String esito;
		if (this.repAnagrafica.existsById(id)) {
			this.repAnagrafica.deleteById(id);
			esito = "eliminazione avvenuta con successo";
		}

		else {
			esito = "id inserito non esistente, eliminazione non riuscita";
		}

		return esito;

	}

	@Override
	public List<Anagrafica> findAll() {

		return this.repAnagrafica.findAll();
	}

	@Override
	public Anagrafica findByCodiceFiscale(Anagrafica anagrafica) {

		return repAnagrafica.findByCodiceFiscale(anagrafica.getCodiceFiscale());
	}

	@Override
	public Boolean existsById(Integer id) {
		return repAnagrafica.existsById(id);
	}

}
