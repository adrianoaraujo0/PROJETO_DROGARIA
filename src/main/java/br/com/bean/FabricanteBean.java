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

	private ListDataModel<Fabricante> fabricantes;

	public ListDataModel<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ListDataModel<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
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
}
