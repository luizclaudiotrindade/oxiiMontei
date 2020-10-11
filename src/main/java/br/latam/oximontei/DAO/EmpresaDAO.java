package br.latam.oximontei.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.latam.oximontei.model.Empresa;




@Repository
public interface EmpresaDAO extends JpaRepository<Empresa, Integer> {	


	

}