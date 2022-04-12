package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Anagrafica")
public class Anagrafica {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "codice_fiscale")
	private String codiceFiscale;	
	@OneToOne(mappedBy = "anagrafica")
	private Utente utente;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "anagrafica")
	private List<Studente> studenti = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public LocalDate getDob() {
		return dob;
	}


	public Utente getUtente() {
		return utente;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}

	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public String toString() {
		return "Anagrafica [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dob=" + dob + ", codice_fiscale=" + codiceFiscale + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anagrafica other = (Anagrafica) obj;
		return Objects.equals(id, other.id);
	}

}
