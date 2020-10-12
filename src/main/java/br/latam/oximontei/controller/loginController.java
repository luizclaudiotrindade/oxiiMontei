package br.latam.oximontei.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.latam.oximontei.DAO.UsuarioDAO;
import br.latam.oximontei.model.Usuario;
import br.latam.oximontei.service.UsuarioService;

@Controller
public class loginController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@GetMapping("login2")
	public String login() {
		return "login/login";
	}

	@PostMapping("/login")
	public String efetuarLogin(Model model, Usuario usuario, RedirectAttributes ra, HttpSession session) {

		usuario = this.usuarioDAO.efetuarLogin(usuario.getNome(), usuario.getSenha());
		if (usuario != null) {
			session.setAttribute("usuarioLogado", usuario);
			model.addAttribute("usuarioLogado", usuario);
			if (usuario.isTipoAdm() || usuario.isTipoFuncionario()) {

				return "login/areaAdm";
			} else {

				return "login/areaUsuario";
			}

		} else {
			ra.addFlashAttribute("mensagem", "Login/senha inválidos");
			return "redirect:/";
		}
	}

	@GetMapping("/cadastro")
	public String cadastro(Usuario usuario, Model model) {
		return "login/cadastroUsuario";
	}

	@PostMapping("/addUsuario")
	public String addUsuario(@Validated Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return cadastro(usuario, model);
		}
		usuario.setTipo("Cliente");
		usuarioDAO.save(usuario);
		return "redirect:listarUsuario";
	}

	@PostMapping("/addFuncionario")
	public String addFuncionario(@Validated Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return cadastro(usuario, model);
		}
		usuario.setTipo("Funcionario");
		usuarioDAO.save(usuario);
		return "redirect:listarUsuario";
	}

	@GetMapping("/listarUsuario") // rota
	public String listUsuario(Model model) {
		model.addAttribute("lista", usuarioDAO.findAll());
		return "login/listUsuario";
	}

	@GetMapping("/editarUsuario")
	public String editarUsuario(Integer id, Model model) {
		Optional<Usuario> usuario = this.usuarioDAO.findById(id);
		if (usuario.isPresent()) {
			model.addAttribute("usuario", usuario.get());
			return "login/cadastroUsuario";
		}

		return "erro/Erro";

	}

	@GetMapping("/excluirUsuario")
	public String excluirUsuario(Integer id) {
		this.usuarioDAO.deleteById(id);
		return "redirect:/listarUsuario";
	}
}
