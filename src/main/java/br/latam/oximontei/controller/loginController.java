package br.latam.oximontei.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.latam.oximontei.DAO.UsuarioDAO;
import br.latam.oximontei.model.Usuario;
import br.latam.oximontei.service.UsuarioService;


@Controller
public class loginController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioDAO usuarioDAO;

	@GetMapping("login2")
	public String login() {
		return "login/login";
	}


	@PostMapping("/login")
	public String efetuarLogin(Usuario usuario, RedirectAttributes ra, HttpSession session) {

		usuario = this.usuarioDAO.efetuarLogin(usuario.getNome(), usuario.getSenha());
		if (usuario != null) {
			session.setAttribute("usuarioLogado", usuario);
			return "login/autenticado";
		} else {
			ra.addFlashAttribute("mensagem", "Login/senha inválidos");
			return "redirect:/";
		}
	}

	@GetMapping("/cadastro")
	public String cadastro() {
		return "login/cadastroUsuario";
	}
	@PostMapping("/addUsuario")
	public String addUsuario(Usuario usuario) {
		usuarioDAO.save(usuario);
		return "login/autenticado";
	}

	@GetMapping("/listarUsuario") //rota 
	public String listUsuario(Model model) {
		model.addAttribute("lista", usuarioDAO.findAll());
		return "login/listUsuario";
	}

	@GetMapping("/editarCargo")
	public String editarCargo(Integer id, Model model) {
		Usuario cargo = this.usuarioDAO.getOne(id);
		return this.listUsuario(model);
	}
	
	@GetMapping("/excluirCargo")
	public String excluirCargo(Integer id) {
		this.usuarioDAO.deleteById(id);
		return "redirect:/cargos";
	}
}
