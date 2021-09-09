package br.com.dao;

import javax.persistence.EntityManager;

import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fabricante f = new Fabricante("GUAR�");
		Produto p = new Produto("NOVO", 7l, 300.0, f);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		FabricanteDao fabricanteDao = new FabricanteDao(em);

		em.getTransaction().begin();
		fabricanteDao.cadastrar(f);
		produtoDao.cadastrar(p);
		em.getTransaction().commit();
		em.close();

	}

}
