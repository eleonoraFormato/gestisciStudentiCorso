package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Esame")
public class Esame {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (name="voto")
	private Integer voto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStudente", nullable = true)
	private Studente studente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMateria", nullable = true)
	private Materia materia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCorso", nullable = true)
	private Corso corso;
	
	public Integer getId() {
		return id;
	}
	public Integer getVoto() {
		return voto;
	}
	public Studente getStudente() {
		return studente;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setVoto(Integer voto) {
		this.voto = voto;
	}
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public Corso getCorso() {
		return corso;
	}
	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	@Override
public String toString() {
	return "Esame [id=" + id + ", voto=" + voto + ", studente=" + studente + ", materia=" + materia + ", corso=" + corso
			+ "]";
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
		Esame other = (Esame) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
