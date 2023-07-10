package com.bollettino.presentation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.bollettino.entities.Bollettino;
import com.bollettino.repo.BollettinoDAO;
import com.bollettino.service.BollettinoService;
import com.bollettino.service.ContoAbilitatoService;
import com.bollettino.service.ValidationService;


@Controller
@SessionAttributes({"CodiceBollettino", "CCDestinatario", "Causale", "Importo"})
@RequestMapping("/")
public class ControllerMVC {
	
	@Autowired
	BollettinoService service;
	
	@Autowired
	ContoAbilitatoService contoAbilitatoService;
	
	@Autowired
	BollettinoDAO dao;
	
	@Autowired
	ValidationService serviceValidation;
	 
	@GetMapping({"/", "home", "index"})
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/pagina-dati-bollettino")
	public String datiBollettino() {
		return "dati-bollettino";
	}
	
	@PostMapping("/dati-bollettino")
	public String pagamentoBollettino(@ModelAttribute Bollettino b, Model m) {
		
		String codiceContoCorrente = b.getCodiceContoDestinatario();
		String codiceBollettino = b.getCodiceBollettino();
		String causale = b.getCausale();
		double importo = b.getImporto();
		boolean codiceContoCorrenteExists = contoAbilitatoService.existsContoCorrente(codiceContoCorrente);
		
		// Controllo back-end tramite REGEX del codiceContoCorrente
		if(!serviceValidation.validateCodiceContoCorrente(codiceContoCorrente)) {
			
			String errorMessage = "Codice conto corrente errato";
			m.addAttribute("errorMessage", errorMessage);
			
			return "errore.html";
		}
		
		// Controllo back-end tramite REGEX del codiceBollettino
		if(!serviceValidation.validateCodiceBollettino(codiceBollettino)) {
			
			String errorMessage = "Codice bollettino errato";
			m.addAttribute("errorMessage", errorMessage);
					
			return "errore.html";
		}
		
		// Controllo back-end tramite REGEX della causale
		if(!serviceValidation.validateCausale(causale)) {
					
			String errorMessage = "Causale contine caratteri non validi";
			m.addAttribute("errorMessage", errorMessage);
			
			return "errore.html";
		}
		
		// Controllo back-end tramite REGEX dell'importo
		if(!serviceValidation.validateImporto(importo)) {
							
			String errorMessage = "Importo inserito non valido";
			m.addAttribute("errorMessage", errorMessage);
					
			return "errore.html";
		}
		
		//FUNZIA se inserisce il codice conto corrente lo riceviamo e lo controlla
		if(!codiceContoCorrenteExists) {
					
			String errorMessage = "Codice conto corrente non abilitato";
			m.addAttribute("errorMessage", errorMessage);
			
			return "errore.html";
		}
		
		service.addDatiBollettino(b);
			
		m.addAttribute("CodiceBollettino", b.getCodiceBollettino());
		m.addAttribute("CCDestinatario", b.getCodiceContoDestinatario());
		m.addAttribute("Causale", b.getCausale());
		m.addAttribute("Importo", b.getImporto());
		
		return "pagamento-bollettino";
	}

	@PostMapping("/pagamento-bollettino")
	public String confermaPagamento(@ModelAttribute Bollettino b, Model m) {	
		
		String nome = b.getNomePagatore();
		String cognome = b.getCognomePagatore();
		long numeroCarta = b.getNumeroCdC();
		System.out.println(numeroCarta);
		//FUNZIA se inserisce il codice conto corrente lo riceviamo e lo controlla
		if(!serviceValidation.validateNomePagatore(nome)) {
							
			String errorMessage = "Nome inserito non corretto";
			m.addAttribute("errorMessage", errorMessage);
					
			return "errore.html";
		}
		
		//FUNZIA se inserisce il codice conto corrente lo riceviamo e lo controlla
		if(!serviceValidation.validateCognomePagatore(cognome)) {
									
			String errorMessage = "Cognome inserito non corretto";
			m.addAttribute("errorMessage", errorMessage);
							
			return "errore.html";
		}
		
		//FUNZIA se inserisce il codice conto corrente lo riceviamo e lo controlla
		if(!serviceValidation.validateNumeroCarta(numeroCarta)) {
									
			String errorMessage = "Numero carta non corretto";
			m.addAttribute("errorMessage", errorMessage);
							
			return "errore.html";
		}
		
		//Mi ricavo l'Id dal DB
		int bollettinoId = dao.findLastId();
		Optional<Bollettino> bollettinoOptional = dao.findById(bollettinoId);
		
		if (bollettinoOptional.isPresent()) {
			//Se bollettinoOptional contiene dei valori, verificato tramite bollettinoOptional.isPresent,
			//vado a prendere la tutti i valori della riga dal DB creando un object chiamato existingBollettino.
			Bollettino existingBollettino = bollettinoOptional.get();
			existingBollettino.setNomePagatore(nome);
	        existingBollettino.setCognomePagatore(cognome);
	        existingBollettino.setNumeroCdC(numeroCarta);
	        
	        //Salva la riga presa dal DB sulla stessa riga
	        service.addDatiBollettino(existingBollettino);
		}
        
		
		m.addAttribute("NomePaga", b.getNomePagatore());
		m.addAttribute("CognomePaga", b.getCognomePagatore());
		m.addAttribute("CdC", b.getNumeroCdC());
		
		return "conferma-pagamento";
	}
}
