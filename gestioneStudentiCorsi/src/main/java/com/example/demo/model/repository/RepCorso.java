package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Corso;

@Repository
public interface RepCorso extends JpaRepository <Corso, Integer> {

}
