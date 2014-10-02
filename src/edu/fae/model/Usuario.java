package edu.fae.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import edu.fae.util.Util;

/**
 * 
 * @author Robson J. P.
 *
 */
@Entity
public class Usuario implements Model {
	private Long id;
	private String nome;
	private String email;
	private String username;
	private String senha;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setSenhaUsuario(String senha) {
		if(senha!=null && senha.trim().length() > 0)
			setSenha(Util.gerarMD5(senha));
	}
	@Transient
	public String getSenhaUsuario() {
		return null;
	}

	
}
