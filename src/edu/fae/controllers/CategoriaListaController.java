package edu.fae.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Categoria;

@ViewScoped
@ManagedBean(name="categoriaListaController")
public class CategoriaListaController extends AbstractListaController<Categoria, CategoriaDao>{
	
	@Override
	protected CategoriaDao getDao() {
		return DaoFactory.getCategoriaDao();
	}

}
