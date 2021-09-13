package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fabricante f = new Fabricante("AÇAI");
		Produto p = new Produto("AÇAI");

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		FabricanteDao fabricanteDao = new FabricanteDao(em);

		em.getTransaction().begin();
		/*List<Produto> buscar = produtoDao.buscarPorNome("");
		buscar.forEach(p2 -> System.out.println("Preço: " + p.getPreco() + ", Descrição: " + p.getDescricao()));
		
		List<Fabricante> buscarF = fabricanteDao.buscarPorNome("");
		buscarF.forEach(p2 -> System.out.println("Nome: " + f.getDescricao()));
		*/
		
		List<Produto> buscar = produtoDao.buscarPorFabricante("SAO LUIZ");
		buscar.forEach(p2 -> System.out.println(buscar));
		
		Double pesquisa = produtoDao.buscarPrecoPorNomeDoProduto("Velho");
		System.out.println("Preço: " + pesquisa);
		em.getTransaction().commit();
		em.close();

	}

}
