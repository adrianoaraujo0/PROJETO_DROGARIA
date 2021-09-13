package br.com.dao;

import java.util.List;

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

	public void remover(Fabricante fabricante) {
		fabricante = em.merge(fabricante);
		this.em.remove(fabricante);
	}

	public Fabricante buscarPorId(Long id) {
		return em.find(Fabricante.class, id);
	}

	public List<Fabricante> buscarTodos() {
		String jpql = "SELECT p FROM Fabricante";
		return em.createQuery(jpql, Fabricante.class).getResultList();
	}

	public List<Fabricante> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Fabricante p WHERE p.descricao = :nome";
		return em.createQuery(jpql, Fabricante.class).setParameter("nome", nome).getResultList();

	}
}
