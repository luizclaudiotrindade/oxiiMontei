package br.latam.oximontei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.latam.oximontei.DAO.UsuarioDAO;
import br.latam.oximontei.model.Usuario;

@Controller
public class loginController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	@GetMapping("login")
	public String login() {
		return "login/login";
	}
	@GetMapping("autenticar")
	public String autenticar() {
		return "login/autenticado" ;
	}
	@PostMapping("/addUsuario")
	public String addUsuario(@ModelAttribute Usuario usuario) {
		usuarioDAO.save(usuario);
		return "login/autenticado" ;
	}
	@GetMapping("/listarUsuario")
	public String listUsuario(Model model) {
		model.addAttribute("lista",usuarioDAO.findAll());
		return "login/listUsuario";
	}
	@GetMapping("/editarUsuario")
	public String editarUsuario(Integer id,Model model) {
		model.addAttribute("usuario",this.usuarioDAO.findById(id));
		return "login";
	}
}
