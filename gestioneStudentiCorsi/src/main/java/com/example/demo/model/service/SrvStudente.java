package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.Response;
import com.example.demo.controller.dto.StudenteDTO;
import com.example.demo.model.Studente;

@Service
public interface SrvStudente {
	public Studente findById(Integer id );
	public Response<StudenteDTO> create(StudenteDTO studenteDto);
	public String delete(Integer id);
	public List<Studente> findAll();
	public Boolean existsById (Integer id);
}
