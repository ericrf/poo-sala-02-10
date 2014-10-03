package edu.fae.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.UsuarioDao;
import edu.fae.model.Usuario;

@ViewScoped
@ManagedBean(name="usuarioFormController")
public class UsuarioFormController extends AbstractFormController<Usuario, UsuarioDao> implements Serializable{
	private static final long serialVersionUID = 3242513191744589911L;

	@Override
	protected UsuarioDao getDao() {
		return DaoFactory.getUsuarioDao();
	}
	
	
	public Usuario getNewModel(){
		return new Usuario();
	}
	
	public Usuario getUsuario(){
		return super.getModel();
	}
	
	
}
