package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.domain.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {

		this.em = em;
	}

	public void cadastrar(Produto produto) {
		em.persist(produto);
	}

	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}

	public Produto buscaPorID(Long id) {

		return em.find(Produto.class, id);

	}

	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.descricao = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();

	}

}
