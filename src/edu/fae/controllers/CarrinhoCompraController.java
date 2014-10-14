package edu.fae.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.fae.model.CarrinhoCompra;
import edu.fae.model.ItemCarrinho;
import edu.fae.model.Produto;

@SessionScoped
@ManagedBean
public class CarrinhoCompraController {

	private CarrinhoCompra carrinho;
	private Produto produto;
	
	@PostConstruct
	private void init() {
		carrinho = new CarrinhoCompra();
	}
	
	public void put(){
		carrinho.adicionarProduto(produto);
		produto = new Produto();
	}
	
	public void remove(){
		carrinho.removerProduto(produto);
		produto = new Produto();
	}
	
	public void removeItem(){
		carrinho.removerItem(produto.getId());
		produto = new Produto();
	}
	
	public double getValorTotal(){
		return carrinho.getValorTotal();
	}
	
	public Map<Long, ItemCarrinho> getItens() {
		return carrinho.getItens();
	}
	
	public List<Entry<Long, ItemCarrinho>> getListItemCarrinho(){
		return new ArrayList<Entry<Long, ItemCarrinho>>(carrinho.getItens().entrySet());
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
