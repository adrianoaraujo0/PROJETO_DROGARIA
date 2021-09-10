package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fabricante f = new Fabricante("GUARÁ");
		Produto p = new Produto("Velho", 250l, 300.0, f);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		FabricanteDao fabricanteDao = new FabricanteDao(em);

		em.getTransaction().begin();
		List<Produto> buscarTodos = produtoDao.buscarTodos();
		buscarTodos.forEach(p2 -> System.out.println(p.getPreco()));
		em.getTransaction().commit();
		em.close();

	}

}
