package com.example.demo.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Utente;

@Repository
public interface RepUtente extends JpaRepository <Utente, Integer>{
	
	@Query( value = "SELECT * FROM utenza WHERE e_mail = ?1 AND password=?2 ", nativeQuery = true)
	Optional<Utente> findByeMailAndPassword(String eMail, String password);

}
