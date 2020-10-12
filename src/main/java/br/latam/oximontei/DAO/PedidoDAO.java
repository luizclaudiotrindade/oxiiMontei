package br.latam.oximontei.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.latam.oximontei.model.Pedido;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Integer> {
	
}
