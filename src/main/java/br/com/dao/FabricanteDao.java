package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.domain.Fabricante;
import br.com.domain.Produto;

public class FabricanteDao {

	private EntityManager em;

	public FabricanteDao(EntityManager em) {

		this.em = em;
	}

	public void cadastrar(Fabricante fabricante) {

		em.persist(fabricante);
	}

	public void remover(Fabricante fabricante) {
		fabricante = em.merge(fabricante);
		this.em.remove(fabricante);
	}

	public Fabricante buscarPorId(Long id) {
		return em.find(Fabricante.class, id);
	}
	
	public List<Fabricante> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Fabricante p WHERE p.nome = :nome";
		return em.createQuery(jpql, Fabricante.class)
				.setParameter("nome", nome)
				.getResultList();

	}

	
	
}
