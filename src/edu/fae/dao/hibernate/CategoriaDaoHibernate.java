package edu.fae.dao.hibernate;

import edu.fae.dao.CategoriaDao;
import edu.fae.model.Categoria;

/**
 * Implementação do CategoriaDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
public class CategoriaDaoHibernate extends AbstractDaoHibernate<Categoria> implements CategoriaDao {

	@Override
	protected String getModelClassName() {
		return "Categoria";
	}

}
