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
	
	private String codiceBollettino;
	private double importo;
	private String causale;
	private String codiceContoDestinatario;
	private String nomePagatore;
	private String cognomePagatore;
	private int numeroCdC;
	private int CVC;
	private int scadenza;
	
	public int getCVC() {
		return CVC;
	}
	public void setCVC(int CVC) {
		this.CVC = CVC;
	}
	public int getScadenza() {
		return scadenza;
	}
	public void setScadenza(int scadenza) {
		this.scadenza = scadenza;
	}
	public String getCognomePagatore() {
		return cognomePagatore;
	}
	public void setCognomePagatore(String cognomePagatore) {
		this.cognomePagatore = cognomePagatore;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String codiceCdcPagatore;
	
	public String getCodiceBollettino() {
		return codiceBollettino;
	}
	public void setCodiceBollettino(String codiceBollettino) {
		this.codiceBollettino = codiceBollettino;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
	public String getCodiceContoDestinatario() {
		return codiceContoDestinatario;
	}
	public void setCodiceContoDestinatario(String codiceContoDestinatario) {
		this.codiceContoDestinatario = codiceContoDestinatario;
	}
	public String getNomePagatore() {
		return nomePagatore;
	}
	public void setNomePagatore(String nomePagatore) {
		this.nomePagatore = nomePagatore;
	}
	public String getCodiceCdcPagatore() {
		return codiceCdcPagatore;
	}
	public void setCodiceCdcPagatore(String codiceCdcPagatore) {
		this.codiceCdcPagatore = codiceCdcPagatore;
	}
	public int getId() {
		return id;
	}
	
}
