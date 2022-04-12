package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.CorsoDTO;
import com.example.demo.controller.response.ResponseCorso;
import com.example.demo.model.Corso;

@Service
public interface SrvCorso {
	public ResponseCorso create(CorsoDTO corsoDTO);
	
	public Corso findById(Integer id);
	
	public String delete (Integer id);
	public List<Corso> findAll();
}
