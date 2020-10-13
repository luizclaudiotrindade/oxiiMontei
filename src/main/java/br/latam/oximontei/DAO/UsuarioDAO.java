package br.latam.oximontei.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.latam.oximontei.model.Usuario;
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
	public Usuario efetuarLogin(String email, String senha);
	
}
