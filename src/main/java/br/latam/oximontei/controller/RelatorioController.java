package br.latam.oximontei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.latam.oximontei.DAO.PedidoDAO;

@Controller
public class RelatorioController {
	@Autowired
	private  PedidoDAO pedidoDAO;
	@GetMapping ("/relatorio") 
	public String relatorio (Model model)
	{
		
		model.addAttribute("lista", pedidoDAO.findAll());
		
		return "Relatorio/relatorio";
	}

}
