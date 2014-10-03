package edu.fae.dao.hibernate;

import edu.fae.dao.CarrinhoCompraDao;
import edu.fae.model.CarrinhoCompra;

/**
 * Implementação do CategoriaDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
public class CarrinhoCompraDaoHibernate extends AbstractDaoHibernate<CarrinhoCompra> implements CarrinhoCompraDao {

	@Override
	protected String getModelClassName() {
		return "CarrinhoCompra";
	}

}
