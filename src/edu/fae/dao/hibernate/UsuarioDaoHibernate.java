package edu.fae.dao.hibernate;

import org.hibernate.Query;

import edu.fae.dao.UsuarioDao;
import edu.fae.model.Usuario;
import edu.fae.util.Util;

/**
 * Implementação do UsuarioDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class UsuarioDaoHibernate extends AbstractDaoHibernate<Usuario> implements UsuarioDao {
	
	@Override
	protected String getModelClassName() {
		return "Usuario";
	}


	public Usuario login(String usuario, String senha) {
		//Cria a consulta de Usuario por id
		Query query = getSession().createQuery("from Usuario where username=:username and senha=:senha");
		//Seta o parâmetro id
		query.setString("username", usuario);
		query.setString("senha", Util.gerarMD5(senha));
		//Executa a consulta retornando um resultado apenas
		return (Usuario) query.uniqueResult();	
	}
	
	
}
