package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.AnagraficaDTO;
import com.example.demo.controller.response.ResponseAnagrafica;
import com.example.demo.model.Anagrafica;

@Service
public interface SrvAnagrafica {
	public Anagrafica findById(Integer id );
	public ResponseAnagrafica create(AnagraficaDTO anagraficaDto);
	public List<Anagrafica> findAll();
	public String delete(Integer id);
	public Anagrafica findByCodiceFiscale(Anagrafica anagrafica);
}
