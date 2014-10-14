package edu.fae.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Categoria;

@ViewScoped
@ManagedBean(name="categoriaFormController")
public class CategoriaFormController extends AbstractFormController<Categoria, CategoriaDao>{

	@Override
	protected CategoriaDao getDao() {
		return DaoFactory.getCategoriaDao();
	}

	@Override
	protected Categoria getNewModel() {
		return new Categoria();
	}

}
