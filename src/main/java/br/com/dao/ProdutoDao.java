package br.com.dao;

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

	public Produto buscarProduto(Long id) {

		return em.find(Produto.class, id);
		
	}

}
