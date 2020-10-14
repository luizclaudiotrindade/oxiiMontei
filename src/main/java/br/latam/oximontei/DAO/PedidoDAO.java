package br.latam.oximontei.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.latam.oximontei.model.Pedido;
import br.latam.oximontei.model.Usuario;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Integer> {
	/*@Query("SELECT u FROM pedido_produto u WHERE u.id_pedido = :idPedido AND u.id_produto = :idProduto")
	public Pedido efetuarLogin(String idPedido, String idProduto);*/
	
	
	
}

