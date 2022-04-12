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
@Table(name = "StatoPagamento")
public class StatoPagamento {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "codicePagamento")
	private String codicePagamento;
	@OneToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, 
			mappedBy = "statoPagamento")
	private List<Studente> studenti = new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public String getCodicePagamento() {
		return codicePagamento;
	}
	public List<Studente> getStudenti() {
		return studenti;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public void setCodicePagamento(String codicePagamento) {
		this.codicePagamento = codicePagamento;
	}
	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}
	
	@Override
	public String toString() {
		return "StatoPagamento [id=" + id + ", descrizione=" + descrizione + "]";
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
		StatoPagamento other = (StatoPagamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
