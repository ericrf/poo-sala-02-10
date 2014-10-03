package edu.fae.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.CarrinhoCompraDao;
import edu.fae.model.CarrinhoCompra;

@ViewScoped
@ManagedBean
public class CarrinhoCompraListaController extends AbstractListaController<CarrinhoCompra, CarrinhoCompraDao>{
	
	@Override
	protected CarrinhoCompraDao getDao() {
		return DaoFactory.getCarrinhoCompraDao();
	}

}
