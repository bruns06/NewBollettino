package com.bollettino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bollettino.entities.Bollettino;
import com.bollettino.repo.BollettinoDAO;

@Service
public class BollettinoService {

	@Autowired
	private BollettinoDAO dao;
	
	public List<Bollettino> getBollettino(){
		return dao.findAll();
	}
	
	// Vado a salvare l'entity Bollettino nel DB ma a quale motivo lo faccio qua?
	public void addDatiBollettino(Bollettino b) {
		dao.save(b);
	}
}
