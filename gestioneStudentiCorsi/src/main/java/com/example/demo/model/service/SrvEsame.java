package com.example.demo.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.EsameDTO;
import com.example.demo.controller.response.ResponseEsame;
import com.example.demo.model.Esame;

@Service
public interface SrvEsame {
	public ResponseEsame create(EsameDTO esameDto);
	public Esame findById(Integer id);
	
	public String delete (Integer id);
	public List<Esame> findAll();
}
