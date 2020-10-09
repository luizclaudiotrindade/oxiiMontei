package br.latam.oximontei.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.latam.oximontei.DAO.UsuarioDAO;
import br.latam.oximontei.model.Usuario;
@Service
public class UsuarioService {
	@Autowired
	private UsuarioDAO usuarioDAO;
	public Usuario efetuarLogin(String nome, String senha) throws ServiceException, NoSuchAlgorithmException {	
		//String senhaCriptografada = criptografarSenha(senha);
		Usuario usuario = this.usuarioDAO.efetuarLogin(nome, senha);
		//Usuario usuario = this.usuarioDAO.efetuarLogin(email, senha);

		if (usuario == null) {
			throw new ServiceException("Login/senha não encontrados");
		}
		return usuario;

	}
	
}
