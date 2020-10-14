package br.latam.oximontei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("index")
	public String index() {
		return "index";
	}
	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
}
