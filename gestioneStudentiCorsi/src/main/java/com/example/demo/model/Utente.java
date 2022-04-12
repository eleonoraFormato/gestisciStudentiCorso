package com.example.demo.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name= "Utente")
public class Utente {
	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "eMail")
	private String eMail;
	@Column (name="password")
	private String password;
	@Column (name="tipoUtente")
	private String tipoUtente;
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_anagrafica", referencedColumnName = "id")
    Anagrafica anagrafica;
	
	public String getTipoUtente() {
		return tipoUtente;
	}
	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}
	
	public Integer getId() {
		return id;
	}
	public String geteMail() {
		return eMail;
	}
	public String getPassword() {
		return password;
	}
	
	public Anagrafica getAnagrafica() {
		return anagrafica;
	}
	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "Utente [id=" + id + ", eMail=" + eMail + ", password=" + password + ", tipoUtente=" + tipoUtente + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(eMail, id, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(eMail, other.eMail) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password);
	}
	public Utente(Integer id) {
		super();
		this.id = id;
	}
	public Utente(Integer id, String eMail, String password, String tipoUtente) {
		super();
		this.id = id;
		this.eMail = eMail;
		this.password = password;
		this.tipoUtente = tipoUtente;
	}
	public Utente() {
		super();
	}
	
	
	
}
