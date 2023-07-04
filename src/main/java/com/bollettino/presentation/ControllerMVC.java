package com.bollettino.presentation;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bollettino.entities.Bollettino;

import ch.qos.logback.core.model.Model;


@Controller
@RequestMapping("/")
public class ControllerMVC {
	
	
	 
	@GetMapping({"/", "home", "index"})
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/dati-bollettino")
	public String datiBollettino() {
		return "dati-bollettino";
	}
	
	@PostMapping("/pagamento-bollettino")
	public String pagamentoBollettino() {
		return "pagamento-bollettino";
	}
	/*@GetMapping("/pagamento-bollettino")
	public String pagamentoBollettino(@ModelAttribute Bollettino formBolletino, Model model) {
		return "pagamento-bollettino";
	}*/
	@PostMapping("/conferma-pagamento")
	public String confermaPagamento() {
		return "conferma-pagamento";
	}
	
	 //@PostMapping("/testi")
	 	//public String addTesto(Bollettino b) {
		 //bs.pagaBollettino(b);
		 //return "redirect:/review";
	 //}
	
}
