package edu.fae.dao.hibernate;

import edu.fae.dao.ProdutoDao;
import edu.fae.model.Produto;

/**
 * Implementação do ProdutoDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class ProdutoDaoHibernate extends AbstractDaoHibernate<Produto> implements ProdutoDao {

	@Override
	protected String getModelClassName() {
		return "Produto";
	}
	
}
