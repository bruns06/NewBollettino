package com.bollettino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bollettino.entities.Bollettino;
import com.bollettino.entities.Utente;
import com.bollettino.repo.UtenteDAO;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteDAO dao;
	
	public List<Utente> getUtente(){
		return dao.findAll();
	}
	
	
	
	public void pagaBollettino(Bollettino b) {
		
		//String codiceB = b.getCodiceBollettino();
		//String causaleB = b.getCausale();
		//double importoB = b.getImporto();
		//String codiceContoB = b.getCodiceContoDestinatario();
		//String nomePagatoreB = b.getNomePagatore();
		//String CdcB = b.getCodiceCdcPagatore();
		
		
		
		
	}
	
}
