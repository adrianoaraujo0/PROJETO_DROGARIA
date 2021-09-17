package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.bean.FabricanteBean;
import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fabricante f = new Fabricante();
		Produto p = new Produto("AÇAI");

		
		//FabricanteBean bean = new FabricanteBean();
		 
		

		EntityManager em = JPAUtil.getEntityManager();
		FabricanteDao dao = new FabricanteDao(em);
		
		List<Fabricante> lista = dao.editar(27l);
		f.setDescricao("FAB27");
		
		for(Fabricante x : lista) {
			x.setDescricao("BEM 10");
			dao.merge(x);
			System.out.println("DEU ROXEDA");
		}
		
		
//		Fabricante alterar = dao.buscarPorId(27l);
//		alterar.setDescricao("ALTERAR");
//		dao.merge(alterar);

		/*List<Produto> buscar = produtoDao.buscarPorNome("");
		buscar.forEach(p2 -> System.out.println("Preço: " + p.getPreco() + ", Descrição: " + p.getDescricao()));
		
		List<Fabricante> buscarF = fabricanteDao.buscarPorNome("");
		buscarF.forEach(p2 -> System.out.println("Nome: " + f.getDescricao()));
		
		
		List<Produto> buscar = produtoDao.buscarPorFabricante("SAO LUIZ");
		buscar.forEach(p2 -> System.out.println(buscar));
		
		Double pesquisa = produtoDao.buscarPrecoPorNomeDoProduto("Velho");
		System.out.println("Preço: " + pesquisa);
		List<Fabricante> lista =  fabricanteDao.Listar();
		System.out.println(lista);
		
		List<Produto> listap = produtoDao.Listar();
		System.out.println(listap);
		*/
		
	
		
		

	}

}
