package edu.fae.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CarrinhoCompra {
	private Map<Long, ItemCarrinho> itens;
	
	public CarrinhoCompra() {
		itens = new HashMap<Long, ItemCarrinho>();
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
	
	public void adicionarProduto(Produto produto){
		ItemCarrinho item = itens.get(produto.getId());
		if(item == null) item = new ItemCarrinho(produto, 0);
		item.setQuantidade((item.getQuantidade() + 1));
		itens.put(produto.getId(), item);
	}
	
	public void removerProduto(Produto produto){
		ItemCarrinho item = itens.get(produto.getId());
		if(item == null) return;
		item.setQuantidade((item.getQuantidade() - 1));
		if(item.getQuantidade() == 0) itens.remove(produto.getId());
		
	}
	
	public void removerItem(Long id){
		itens.remove(id);
	}

	public Map<Long, ItemCarrinho> getItens() {
		return itens;
	}

}
