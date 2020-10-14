package br.latam.oximontei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.latam.oximontei.DAO.ProdutoDAO;
import br.latam.oximontei.model.Produto;
@Controller
public class ProdutoController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@GetMapping("/produto")
	public String Produto() {
		return "Produto/produto";
	}

	@PostMapping("/addProduto")
	public String addProduto(Produto produto) {
		produtoDAO.save(produto);
		return "Produto/ProdutoCadastrado";

	}
}

