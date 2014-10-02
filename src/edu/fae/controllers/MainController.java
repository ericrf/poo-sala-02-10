package edu.fae.controllers;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import edu.fae.model.Usuario;


@RequestScoped
@ManagedBean(name="mainController")
public class MainController {

	public Usuario getUsuarioLogado() {
		return (Usuario) getSession().get("usuarioLogado");
	}
	
	/**
	 * Retorna um map que representa as variáveis guardadas
	 * a sessão
	 */
	private Map<String, Object> getSession() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}	
}
