package edu.fae.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.Dao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Categoria;
import edu.fae.model.Model;

public abstract class AbstractListaController<MODEL extends Model, DAO extends Dao<MODEL>> {
	private DAO dao = getDao();//DaoFactory.getCategoriaDao();
	
	
	protected abstract DAO getDao();
	/**
	 * Armazena os categorias mostrados na view
	 */
	private List<MODEL> models;
	
	/**
	 * Recebe o id do categoria para ser excluído
	 */
	private Long id;
	
	/**
	 * Método que é chamado quando a view é aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void buscaTodos() {
		models = dao.findAll();
	}

	/**
	 * Método que exclui um categoria
	 */
	public void excluir() {
		if(id!=null) {
			MODEL model = dao.findById(id);
			if(model!=null) {
				dao.remove(model);
				
				//Chama o buscaTodos para atualizar a lista
				buscaTodos();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<MODEL> getModels() {
		return models;
	}

}
