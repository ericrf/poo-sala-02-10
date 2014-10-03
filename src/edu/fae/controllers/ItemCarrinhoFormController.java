package edu.fae.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.ItemCarrinhoDao;
import edu.fae.model.ItemCarrinho;

@ViewScoped
@ManagedBean
public class ItemCarrinhoFormController extends AbstractFormController<ItemCarrinho, ItemCarrinhoDao>{

	@Override
	protected ItemCarrinhoDao getDao() {
		return DaoFactory.getItemCarrinhoDao();
	}

	@Override
	protected ItemCarrinho getNewModel() {
		return new ItemCarrinho();
	}

}
