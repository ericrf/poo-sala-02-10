package edu.fae.dao;

import edu.fae.model.Usuario;

/**
 * Definição de Dao de Usuário
 * 
 * @author Robson J. P.
 * @since 1.0
 */
public interface UsuarioDao extends Dao<Usuario> {
	
	
	public Usuario login(String usuario, String senha);
}
