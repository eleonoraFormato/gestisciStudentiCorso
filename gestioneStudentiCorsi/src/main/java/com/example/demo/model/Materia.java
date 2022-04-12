package com.example.demo.model;

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
@Table(name = "Materia")
public class Materia {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (name="nome")
	private String nome;
	@Column (name="descrizione")
	private String descrizione;
	@OneToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, 
			mappedBy = "materia")
	
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
	public List<Esame> getEsami() {
		return esami;
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
	public void seEsami(List<Esame> esami) {
		this.esami = esami;
	}
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + "]";
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
		Materia other = (Materia) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
