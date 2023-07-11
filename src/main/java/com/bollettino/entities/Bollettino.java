package com.bollettino.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bollettini")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bollettino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String codiceContoDestinatario;
	private String codiceBollettino;
	private String causale;
	private double importo;
	private String nomePagatore;
	private String cognomePagatore;
	private long numeroCdC;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodiceContoDestinatario() {
		return codiceContoDestinatario;
	}
	public void setCodiceContoDestinatario(String codiceConto) {
		this.codiceContoDestinatario = codiceConto;
	}
	public String getCodiceBollettino() {
		return codiceBollettino;
	}
	public void setCodiceBollettino(String codiceBollettino) {
		this.codiceBollettino = codiceBollettino;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public String getNomePagatore() {
		return nomePagatore;
	}
	public void setNomePagatore(String nomePagatore) {
		this.nomePagatore = nomePagatore;
	}
	public String getCognomePagatore() {
		return cognomePagatore;
	}
	public void setCognomePagatore(String cognomePagatore) {
		this.cognomePagatore = cognomePagatore;
	}
	public long getNumeroCdC() {
		return numeroCdC;
	}
	public void setNumeroCdC(long numeroCdC) {
		this.numeroCdC = numeroCdC;
	}
	
}
