package edu.fae.controllers;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.UsuarioDao;
import edu.fae.model.Usuario;


@RequestScoped
@ManagedBean(name="loginController")
public class LoginController {
	private UsuarioDao usuarioDao = DaoFactory.getUsuarioDao();
	private String usuario;
	private String senha;
	
	public String logar() {
		Usuario user = usuarioDao.login(usuario, senha);
		if(user==null) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario e/ou senha invalidos!", null)
				);
			return "login.xhtml";
		}else{
			
			getSession().put("usuarioLogado", user);
						
			return "../main.xhtml?faces-redirect=true";
		}
	}
	
	public String sair() {
		getSession().remove("usuarioLogado");
		return "admin/login.xhtml?faces-redirect=true";
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Retorna um map que representa as variáveis guardadas
	 * a sessão
	 */
	private Map<String, Object> getSession() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}	
}
