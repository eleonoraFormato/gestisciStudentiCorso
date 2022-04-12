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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Studente")
public class Studente {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "dataIscrizione")
	private LocalDate dataIscrizione;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCorso", nullable = true)
	private Corso corso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStatoPagamento", nullable = true)
	private StatoPagamento statoPagamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAnagrafica", nullable = true)
	private Anagrafica anagrafica;
	
	@OneToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, 
			mappedBy = "studente")
	private List<Esame> esami = new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public LocalDate getDataIscrizione() {
		return dataIscrizione;
	}
	public Corso getCorso() {
		return corso;
	}
	public StatoPagamento getStatoPagamento() {
		return statoPagamento;
	}
	public Anagrafica getAnagrafica() {
		return anagrafica;
	}
	public List<Esame> getEsami() {
		return esami;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	public void setStatoPagamento(StatoPagamento statoPagamento) {
		this.statoPagamento = statoPagamento;
	}
	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
	@Override
	public String toString() {
		return "Studente [id=" + id + ", dataIscrizione=" + dataIscrizione + ", corso=" + corso + ", statoPagamento="
				+ statoPagamento + ", anagrafica=" + anagrafica +  "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, anagrafica);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return Objects.equals(id, other.id) && Objects.equals(anagrafica, other.anagrafica);
	}
	public Studente(LocalDate dataIscrizione, Corso corso, StatoPagamento statoPagamento, Anagrafica anagrafica) {
		super();
		this.dataIscrizione = dataIscrizione;
		this.corso = corso;
		this.statoPagamento = statoPagamento;
		this.anagrafica = anagrafica;
	}
	public Studente(Integer id, LocalDate dataIscrizione, Corso corso, StatoPagamento statoPagamento,
			Anagrafica anagrafica) {
		super();
		this.id = id;
		this.dataIscrizione = dataIscrizione;
		this.corso = corso;
		this.statoPagamento = statoPagamento;
		this.anagrafica = anagrafica;
	}
	public Studente() {
		super();
	}
	
	
}
