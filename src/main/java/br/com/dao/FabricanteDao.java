package br.com.dao;

import javax.persistence.EntityManager;

import br.com.domain.Fabricante;

public class FabricanteDao {

	private EntityManager em;

	public FabricanteDao(EntityManager em) {

		this.em = em;
	}

	public void cadastrar(Fabricante fabricante) {

		em.persist(fabricante);
	}

}
