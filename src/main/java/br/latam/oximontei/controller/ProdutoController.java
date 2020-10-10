package br.latam.oximontei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.latam.oximontei.DAO.ProdutoDAO;
import br.latam.oximontei.model.Produto;

public class ProdutoController {

	@GetMapping("/produto")
	public String Produto() {
		return "Produto/Produto";
	}

	@PostMapping("/addProduto")
	public String addProduto(Produto Produto) {
		ProdutoDAO.save(Produto);
		return "Produto/autenticado";

	}
}