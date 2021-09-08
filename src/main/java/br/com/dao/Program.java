package br.com.dao;

import javax.persistence.EntityManager;

import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fabricante f = new Fabricante("SAO LUIZ");

		Produto p = new Produto(1l, "Lançamento", 5l, 20.0);

		EntityManager em = new JPAUtil().getEntityManager();
		Dao dao = new Dao(em);

		em.getTransaction().begin();
		dao.cadastrar(p);
		em.getTransaction().commit();
		em.close();

	}

}
