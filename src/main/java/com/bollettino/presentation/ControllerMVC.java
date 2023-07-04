package com.bollettino.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bollettino.entities.Bollettino;
import com.bollettino.repo.BollettinoDAO;
import com.bollettino.service.BollettinoService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes({"CodiceBollettino", "CCDestinatario", "Causale", "Importo"})
@RequestMapping("/")
public class ControllerMVC {
	
	int id = 0;
	
	@Autowired
	BollettinoService service;
	
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
	public String pagamentoBollettino(Bollettino b, Model m) {
		service.addDatiBollettino(b);
		id = b.getId();		
		m.addAttribute("CodiceBollettino", b.getCodiceBollettino());
		m.addAttribute("CCDestinatario", b.getCodiceContoDestinatario());
		m.addAttribute("Causale", b.getCausale());
		m.addAttribute("Importo", b.getImporto());
		
		return "pagamento-bollettino";
	}
	/*@GetMapping("/pagamento-bollettino")
	public String pagamentoBollettino(@ModelAttribute Bollettino formBolletino, Model model) {
		return "pagamento-bollettino";
	}*/
	@PostMapping("/conferma-pagamento")
	public String confermaPagamento(Model m, Bollettino b, HttpSession httpSession) {	
		
		m.addAttribute("NomePaga", b.getNomePagatore());
		m.addAttribute("CognomePaga", b.getCognomePagatore());
		m.addAttribute("CdC", b.getCodiceCdcPagatore());
		
		return "conferma-pagamento";
	}
	
	 //@PostMapping("/testi")
	 	//public String addTesto(Bollettino b) {
		 //bs.pagaBollettino(b);
		 //return "redirect:/review";
	 //}
	
}
