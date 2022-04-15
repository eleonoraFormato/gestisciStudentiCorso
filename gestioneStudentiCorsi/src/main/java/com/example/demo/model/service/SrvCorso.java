package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.Response;
import com.example.demo.controller.dto.CorsoDTO;
import com.example.demo.model.Corso;

@Service
public interface SrvCorso {
	public Response<CorsoDTO> create(CorsoDTO corsoDTO);
	
	public Corso findById(Integer id);
	public Boolean existsById (Integer id);
	public String delete (Integer id);
	public List<Corso> findAll();
}
