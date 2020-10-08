package br.latam.oximontei.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.latam.oximontei.model.Usuario;
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

	
}
