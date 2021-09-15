package br.com.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;

import br.com.dao.FabricanteDao;
import br.com.domain.Fabricante;
import br.com.util.JPAUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante; //FALAR COM O CHICO
	private ListDataModel<Fabricante> fabricantes;

	public ListDataModel<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ListDataModel<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@PostConstruct  //é carregado ao iniciar da pag
	public void prepararLista() {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			FabricanteDao dao = new FabricanteDao(em);
			List<Fabricante> lista = dao.Listar();
			fabricantes = new ListDataModel<Fabricante>(lista);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void prepararNovo() {
		fabricante = new Fabricante();
	}
	
	public void novo() {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			FabricanteDao dao = new FabricanteDao(em);
			dao.cadastrar(fabricante);
			
			prepararLista();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
