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
import javax.persistence.Table;

@Entity
@Table(name = "Corso")
public class Corso {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "dataInizio")
	private LocalDate dataInizio;
	@Column(name = "numeroEsami")
	private Integer numeroEsami;
	@OneToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, 
			mappedBy = "corso")
	
	private List<Esame> esami = new ArrayList<>();
	
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public List<Esame> getEsami() {
		return esami;
	}
	public Integer getNumeroEsami() {
		return numeroEsami;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
	public void setNumeroEsami(Integer numeroEsami) {
		this.numeroEsami = numeroEsami;
	}

	@Override
	public String toString() {
		return "Corso [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", dataInizio=" + dataInizio
				+  ", numeroEsami=" + numeroEsami + "]";
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
		Corso other = (Corso) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
