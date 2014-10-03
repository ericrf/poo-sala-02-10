package edu.fae.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemCarrinho implements Model {
	private static final long serialVersionUID = -9002267549508807167L;

	@Id
	@GeneratedValue
	private Long id;

	private int quantidade;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private Produto produto;
	
	public double getValorTotal() {
		return getQuantidade() * produto.getValor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
