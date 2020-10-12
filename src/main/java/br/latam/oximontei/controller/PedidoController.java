package br.latam.oximontei.controller;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.latam.oximontei.DAO.PedidoDAO;
import br.latam.oximontei.DAO.ProdutoDAO;
import br.latam.oximontei.DAO.UsuarioDAO;
import br.latam.oximontei.model.Pedido;
import br.latam.oximontei.model.Produto;
import br.latam.oximontei.model.Usuario;

@Controller
public class PedidoController {

	@Autowired
	private ProdutoDAO produtoDAO;
	@Autowired
	private PedidoDAO pedidoDAO;
	@Autowired
	private UsuarioDAO usuarioDAO;
	@GetMapping("/pedido")
	public String Pedido(Model model, HttpSession session) {
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("usuarioLogado", usuario);
		model.addAttribute("listaPao", produtoDAO.findAllByTipo("PÃO"));
		model.addAttribute("listaCarne", produtoDAO.findAllByTipo("CARNE"));
		model.addAttribute("listaAcompanhamento", produtoDAO.findAllByTipo("ACOMPANHAMENTO"));
		model.addAttribute("listaBebida", produtoDAO.findAllByTipo("BEBIDA"));
		return "Pedido/Pedido";
	}
	
	@PostMapping("/pedidoSave")
	public String pedidoPao(Model model, Integer paoId,Integer carneId,Integer acompanhamentoId,Integer bebidaId ) {
		Pedido pedido = new Pedido();
		Optional<Produto> pao = produtoDAO.findById(paoId);
		Optional<Produto> carne = produtoDAO.findById(carneId);
		Optional<Produto> acompanhamento = produtoDAO.findById(acompanhamentoId);
		Optional<Produto> bebida = produtoDAO.findById(bebidaId);
		
		pedido.setProdutos(Arrays.asList(pao.get(),carne.get(),acompanhamento.get(),bebida.get()));
		Pedido pedidoSalvo= pedidoDAO.save(pedido);
		
		model.addAttribute("pedido",pedidoSalvo);
		return "Pedido/NotaFiscal";
	}
}