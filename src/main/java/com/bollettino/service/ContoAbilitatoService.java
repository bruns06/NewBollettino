package com.bollettino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bollettino.entities.ContoAbilitato;
import com.bollettino.repo.ContoAbilitatoDAO;

@Service
public class ContoAbilitatoService {

	@Autowired
	private ContoAbilitatoDAO dao;
	
	public List<ContoAbilitato> getContoAbilitato(){
		return dao.findAll();
	}
	
	public boolean existsContoCorrente(String codiceConto) {
		ContoAbilitato contoAbilitato = dao.findByCodiceConto(codiceConto);
		return contoAbilitato != null;
	}
}
