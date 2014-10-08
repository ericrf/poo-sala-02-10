package edu.fae.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import edu.fae.model.ItemCarrinho;
import edu.fae.model.Produto;

@SessionScoped
@ManagedBean
public class CarrinhoCompraController {

	private Map<Long, ItemCarrinho> itens;
	private Produto produto;
	
	@PostConstruct
	private void init() {
		setItens(new HashMap<Long, ItemCarrinho>());
	}
	
	public void put(){
		ItemCarrinho item = itens.get(getProduto().getId());
		if(item == null) item = new ItemCarrinho(getProduto(), 0);
		item.setQuantidade((item.getQuantidade() + 1));
		itens.put(getProduto().getId(), item);
	}
	
	public void remove(){
		ItemCarrinho item = itens.get(getProduto().getId());
		if(item == null) return;
		item.setQuantidade((item.getQuantidade() - 1));
		if(item.getQuantidade() == 0) itens.remove(getProduto().getId());
	}
	
	public double getValorTotal(){
		double valorTotal = 0.0;
		Set<Entry<Long,ItemCarrinho>> set = itens.entrySet();
		for (Entry<Long, ItemCarrinho> entry : set) {
			ItemCarrinho item = entry.getValue();
			valorTotal+=item.getValorTotal();
		}
		return valorTotal;
	}
	
	public Map<Long, ItemCarrinho> getItens() {
		return itens;
	}
	
	public List<Entry<Long, ItemCarrinho>> getListItemCarrinho(){
		return new ArrayList<Entry<Long, ItemCarrinho>>(itens.entrySet());
	}
	
	public void setItens(Map<Long, ItemCarrinho> itens) {
		this.itens = itens;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Quantidade Editada", ((Produto) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modificação Cancelada", ((Produto) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
