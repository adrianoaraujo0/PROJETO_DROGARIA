package br.com.dao;

import javax.persistence.EntityManager;

import br.com.domain.Produto;

public class Dao {

	private EntityManager em;

	public Dao(EntityManager em) {

		this.em = em;
	}

	public void cadastrar(Produto produto) {

		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}

}
