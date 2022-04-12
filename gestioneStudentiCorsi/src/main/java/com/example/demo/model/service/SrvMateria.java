package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.MateriaDTO;
import com.example.demo.controller.response.ResponseMateria;
import com.example.demo.model.Materia;

@Service
public interface SrvMateria {
	public ResponseMateria create(MateriaDTO materiaDto);
	public Materia findById(Integer id);
	
	public String delete (Integer id);
	public List<Materia> findAll();
}
