package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Response;
import com.example.demo.controller.dto.StudenteDTO;
import com.example.demo.model.Studente;
import com.example.demo.model.repository.RepStudente;

@Service
public class SrvStudenteImpl implements SrvStudente {
	@Autowired
	RepStudente repStudente;
	@Autowired
	SrvCorso srvCorso;
	@Autowired
	SrvAnagrafica srvAnagrafica;
	@Autowired
	SrvStatoPagamento srvStatoPagamento;
	
	Response<StudenteDTO> response;
	List<StudenteDTO>lista;
	@Override
	public Studente findById(Integer id) {

		return this.repStudente.findById(id).get();
	}

	@Override
	public Response<StudenteDTO> create(StudenteDTO studenteDto) {

		try {
			Studente studente = studenteDto.cambiaTipoFromDto(studenteDto);
			studente.setCorso(srvCorso.findById(studenteDto.getIdCorso()));
			studente.setStatoPagamento(srvStatoPagamento.findById(studenteDto.getIdStatoPagamento()));
			studente.setAnagrafica(srvAnagrafica.findById(studenteDto.getIdAnagrafica()));
			lista = response.aggiungi(studenteDto.cambiaTipoToDto(this.repStudente.save(studente)));
			response.setLista(lista);
			response.setMsg("Caricamento Studente riuscito con successo!");
		} catch (Exception e) {
			response.setMsg("Ops! Qualcosa è andato storto " + e.getMessage());
			response.setLista(null);
		}

		return response;
	}

	@Override
	public String delete(Integer id) {
		String esito;
		if (this.repStudente.existsById(id)) {
			this.repStudente.deleteById(id);
			esito = "eliminazione avvenuta con successo";
		}

		else {
			esito = "id inserito non esistente, eliminazione non riuscita";
		}

		return esito;
	}

	@Override
	public List<Studente> findAll() {
		return this.repStudente.findAll();
	}
}
