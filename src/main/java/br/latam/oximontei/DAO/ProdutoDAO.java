package br.latam.oximontei.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.latam.oximontei.model.Produto;


@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

	@Query("SELECT u FROM Produto u WHERE u.tipo = :tipo AND u.status = :status AND u.descricao = :descricao AND u.img = :img AND u.valor = :valor AND u.id_produto = :id_produto AND u.nome = :nome")
	public Produto efetuarLogin(String tipo, String status, String descricao, String img, Integer valor,
			Integer id_produto, String nome);

}