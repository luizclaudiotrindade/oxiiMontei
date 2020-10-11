package br.latam.oximontei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.latam.oximontei.DAO.EmpresaDAO;
import br.latam.oximontei.model.Empresa;


@Controller
public class EmpresaController {

	@Autowired
	private EmpresaDAO EmpresaDAO;
	
	@GetMapping("/Empresa")
	public String Empresa() {
		return "Empresa/Empresa";
	}

	@PostMapping("/addEmpresa")
	public String addEmpresa(Empresa Empresa) {
		EmpresaDAO.save(Empresa);
		return "Empresa/EmpresaCadastrado";

	}
}