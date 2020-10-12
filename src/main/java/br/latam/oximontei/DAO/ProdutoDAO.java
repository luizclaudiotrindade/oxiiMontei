package br.latam.oximontei.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.latam.oximontei.model.Produto;


@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

public List <Produto> findAllByTipo(String tipo);

}