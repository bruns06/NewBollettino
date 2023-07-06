package com.bollettino.presentation;

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
	 
	@GetMapping({"/", "home", "index"})
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/dati-bollettino")
	public String datiBollettino() {
		return "dati-bollettino";
	}
	
	@PostMapping("/pagamento-bollettino")
	public String pagamentoBollettino(@ModelAttribute Bollettino b, Model m) {
		service.addDatiBollettino(b);
			
		m.addAttribute("CodiceBollettino", b.getCodiceBollettino());
		m.addAttribute("CCDestinatario", b.getCodiceContoDestinatario());
		m.addAttribute("Causale", b.getCausale());
		m.addAttribute("Importo", b.getImporto());
		
		Bollettino formBollettino = new Bollettino();
		String codiceBollettino = b.getCodiceBollettino();
		formBollettino.setCodiceBollettino(codiceBollettino);
		//dao.save(formBollettino);
		
		int bollettinoId = dao.findLastId();
		Bollettino bollettino = dao.findById(bollettinoId).orElse(null);
		//System.out.println(bollettino);
		//funzia anche la query per trovare l'id MAX
		System.out.println(bollettinoId);
		
		String codiceContoCorrente = b.getCodiceContoDestinatario();
		boolean codiceContoCorrenteExists = contoAbilitatoService.existsContoCorrente(codiceContoCorrente);
		
		//FUNZIA se inserisce il codice conto corrente lo riceviamo e lo controlla
		if(codiceContoCorrenteExists) {
			System.out.println(codiceContoCorrente);
		}
		else
		{
			System.out.println("non funzia");
		}
		return "pagamento-bollettino";
	}

	@PostMapping("/conferma-pagamento")
	public String confermaPagamento(Model m, Bollettino b) {	
		
		m.addAttribute("NomePaga", b.getNomePagatore());
		m.addAttribute("CognomePaga", b.getCognomePagatore());
		m.addAttribute("CdC", b.getCodiceCdcPagatore());
		
		return "conferma-pagamento";
	}
}
