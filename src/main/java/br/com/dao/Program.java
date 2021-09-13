package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fabricante f = new Fabricante("A�AI");
		Produto p = new Produto("A�AI");

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		FabricanteDao fabricanteDao = new FabricanteDao(em);

		em.getTransaction().begin();
		/*List<Produto> buscar = produtoDao.buscarPorNome("");
		buscar.forEach(p2 -> System.out.println("Pre�o: " + p.getPreco() + ", Descri��o: " + p.getDescricao()));
		
		List<Fabricante> buscarF = fabricanteDao.buscarPorNome("");
		buscarF.forEach(p2 -> System.out.println("Nome: " + f.getDescricao()));
		*/
		
		List<Produto> buscar = produtoDao.buscarPorFabricante("SAO LUIZ");
		buscar.forEach(p2 -> System.out.println(buscar));
		
		Double pesquisa = produtoDao.buscarPrecoPorNomeDoProduto("Velho");
		System.out.println("Pre�o: " + pesquisa);
		em.getTransaction().commit();
		em.close();

	}

}
