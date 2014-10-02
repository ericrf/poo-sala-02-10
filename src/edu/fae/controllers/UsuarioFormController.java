package edu.fae.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.UsuarioDao;
import edu.fae.model.Usuario;

@ViewScoped
@ManagedBean(name="usuarioFormController")
public class UsuarioFormController extends AbstractFormController<Usuario, UsuarioDao>{

	@Override
	protected UsuarioDao getDao() {
		return DaoFactory.getUsuarioDao();
	}

	@Override
	protected Usuario getNewModel() {
		return new Usuario();
	}
	
}
