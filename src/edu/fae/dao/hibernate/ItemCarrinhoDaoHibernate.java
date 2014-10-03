package edu.fae.dao.hibernate;

import edu.fae.dao.ItemCarrinhoDao;
import edu.fae.model.ItemCarrinho;

/**
 * Implementação do CategoriaDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
public class ItemCarrinhoDaoHibernate extends AbstractDaoHibernate<ItemCarrinho> implements ItemCarrinhoDao {

	@Override
	protected String getModelClassName() {
		return "Categoria";
	}

}
