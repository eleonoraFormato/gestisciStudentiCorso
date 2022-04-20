package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Materia;

@Repository
public interface RepMateria extends JpaRepository <Materia, Integer>{

	@Query( value = "SELECT * FROM materia WHERE ?1 = ?2 ", nativeQuery = true)
	public List<Materia> findBy(String parametro, String valore);
}
