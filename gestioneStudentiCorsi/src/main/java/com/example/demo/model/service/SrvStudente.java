package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.StudenteDTO;
import com.example.demo.controller.response.ResponseStudente;
import com.example.demo.model.Studente;

@Service
public interface SrvStudente {
	public Studente findById(Integer id );
	public ResponseStudente create(StudenteDTO studenteDto);
	public String delete(Integer id);
	public List<Studente> findAll();
}
