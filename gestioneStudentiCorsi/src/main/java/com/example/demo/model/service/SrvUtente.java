package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.Response;
import com.example.demo.controller.dto.UtenteDTO;
import com.example.demo.model.Utente;

@Service
public interface SrvUtente {
	public Response<UtenteDTO> create(UtenteDTO utenzaDto);
	public Utente findById(Integer id);	
	public String delete (Integer id);
	public Boolean existsById (Integer id);
	public Utente findByeMailAndPassword(String eMail, String password);
	public List<Utente> findAll();
}
