package br.latam.oximontei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.latam.oximontei.DAO.PedidoDAO;
import br.latam.oximontei.model.Pedido;

@Controller
public class PedidoController {

	@Autowired
	private PedidoDAO produtoDAO;
	
	@GetMapping("/Pedido")
	public String Pedido() {
		return "Pedido/Pedido";
	}

	@PostMapping("/addPedido")
	public String addPedido(Pedido Pedido) {
		produtoDAO.save(Pedido);
		return "Pedido/PedidoCadastrado";

	}
}