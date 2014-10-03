package edu.fae.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class CarrinhoCompra implements Model{
	private static final long serialVersionUID = 3780198785804886280L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<ItemCarrinho> itens;
	
	public double getValorTotal(){
		double valorTotal = 0.0;
		for (ItemCarrinho item : itens) 
			valorTotal+=item.getValorTotal();
		return valorTotal;
	}
	
	public void adicionarProduto(Produto produto){
		ItemCarrinho itemCarrinho = new ItemCarrinho();
		itemCarrinho.setProduto(produto);
		itens.add(itemCarrinho);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}
}
