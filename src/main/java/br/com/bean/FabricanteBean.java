package br.com.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;

import org.postgresql.util.PSQLException;

import br.com.dao.FabricanteDao;
import br.com.domain.Fabricante;
import br.com.util.JPAUtil;
import br.com.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante; 
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

	@PostConstruct // é carregado ao iniciar da pag
	public void prepararLista() {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			FabricanteDao dao = new FabricanteDao(em);
			List<Fabricante> lista = dao.Listar();
			fabricantes = new ListDataModel<Fabricante>(lista);

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
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

			JSFUtil.adicionarMensagemSucesso("Fabricante salvo com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararExcluir() {
		fabricante = fabricantes.getRowData();
	}
	
	public void excluir() {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			FabricanteDao dao = new FabricanteDao(em);
			dao.remover(fabricante);

			prepararLista();

			JSFUtil.adicionarMensagemSucesso("Removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

}
