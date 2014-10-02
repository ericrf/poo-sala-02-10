package edu.fae.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.ProdutoDao;
import edu.fae.model.Produto;

@ViewScoped
@ManagedBean(name="produtoListaController")
public class ProdutoListaController {
	private ProdutoDao produtoDao = DaoFactory.getProdutoDao();
	/**
	 * Armazena os produtos mostrados na view
	 */
	private List<Produto> produtos;
	
	/**
	 * Recebe o id do produto para ser excluído
	 */
	private Long id;
	
	/**
	 * Método que é chamado quando a view é aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void buscaTodos() {
		produtos = produtoDao.findAll();
	}

	/**
	 * Método que exclui um produto
	 */
	public void excluir() {
		if(id!=null) {
			Produto produto = produtoDao.findById(id);
			if(produto!=null) {
				produtoDao.remove(produto);
				
				//Chama o buscaTodos para atualizar a lista
				buscaTodos();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
}
