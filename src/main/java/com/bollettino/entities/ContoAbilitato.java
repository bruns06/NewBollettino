package com.bollettino.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conti_abilitati")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContoAbilitato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String codiceConto;
	private String nomeIntestatario;
	
	public String getCodiceConto() {
		return codiceConto;
	}
	public void setCodiceConto(String codiceConto) {
		this.codiceConto = codiceConto;
	}
	public String getNomeIntestatario() {
		return nomeIntestatario;
	}
	public void setNomeIntestatario(String nomeIntestatario) {
		this.nomeIntestatario = nomeIntestatario;
	}
	public int getId() {
		return id;
	}
	
}
