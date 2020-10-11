package br.latam.oximontei.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.latam.oximontei.model.Produto;


@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer> {



}