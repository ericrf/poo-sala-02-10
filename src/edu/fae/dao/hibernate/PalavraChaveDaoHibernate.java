package edu.fae.dao.hibernate;

import edu.fae.dao.PalavraChaveDao;
import edu.fae.model.PalavraChave;

/**
 * Implementação do PalavraChaveDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class PalavraChaveDaoHibernate extends AbstractDaoHibernate<PalavraChave> implements PalavraChaveDao {

	@Override
	protected String getModelClassName() {
		return "PalavraChave";
	}
	
}
