package br.com.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.ProdutoDao;
import br.com.domain.Produto;
import br.com.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

	private Produto produto;
	private ProdutoDao dao = new ProdutoDao();
	private ArrayList<Produto> produtos;
	private ArrayList<Produto> produtosFiltrados;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(ArrayList<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	//// METODOS
	public void cadastrar(Produto produto) {
		dao.cadastrar(produto);
	}

	public void excluir(Long id) {
		dao.remover(id);
	}

	public void alterar(Produto produto) {
		dao.editar(produto);
	}

	public void carregarListagem() {
		try {
			produtos = dao.ListarFabricanteProduto();
			
			//JSFUtil.adicionarMensagemSucesso("");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

}
