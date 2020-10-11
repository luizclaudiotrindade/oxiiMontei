package br.latam.oximontei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdmController {

	@GetMapping("/areaAdm")
	public String areaAdm() {
		return "login/AreaAdm";

	}

	@GetMapping("/areaUsuario")
	public String areaUsuario() {
		return "login/Areausuario";

	}
}
