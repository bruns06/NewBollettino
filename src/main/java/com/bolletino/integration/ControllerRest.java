package com.bolletino.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bollettino.entities.Bollettino;
import com.bollettino.entities.ContoAbilitato;
import com.bollettino.entities.Utente;
import com.bollettino.service.BollettinoService;
import com.bollettino.service.ContoAbilitatoService;
import com.bollettino.service.UtenteService;

@RestController
public class ControllerRest {

	@Autowired
	private BollettinoService serviceBollettino;
	@Autowired
	private ContoAbilitatoService serviceContoAbilitato;
	@Autowired
	private UtenteService serviceUtente;
	
	@GetMapping("bollettini")
	public List<Bollettino> getBollettino(){
		return serviceBollettino.getBollettino();
	}
	
	@GetMapping("conti_abilitati")
	public List<ContoAbilitato> getContoAbilitatos(){
		return serviceContoAbilitato.getContoAbilitato();
	}
	
	@GetMapping("utenti")
	public List<Utente> getUtente(){
		return serviceUtente.getUtente();
	}
	 
	 
}

