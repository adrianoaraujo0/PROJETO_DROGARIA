package br.com.dao;

import javax.persistence.EntityManager;

import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fabricante f = new Fabricante("GUAR�");
		Produto p = new Produto("Velho", 250l, 300.0, f);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		FabricanteDao fabricanteDao = new FabricanteDao(em);

		em.getTransaction().begin();
		Produto produto = produtoDao.buscarProduto(7l);

		Fabricante fabricante = fabricanteDao.buscarFabricante(7l);

		System.out.println(produto.getPreco() + ", " + produto.getQuantidade() + ", " + fabricante.getDescricao());
		em.getTransaction().commit();
		em.close();

	}

}
