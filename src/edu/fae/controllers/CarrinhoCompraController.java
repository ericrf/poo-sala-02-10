package edu.fae.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

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
	
	
	public void enviarEmail() {
		try {
			HtmlEmail email = new HtmlEmail();
			
			//Setar o ip ou dns do servidor de e-mail
			email.setHostName("xxx.xxx.xxx");
			
			email.addTo("");
			email.setFrom(""); 
			email.setSubject(""); 
			email.setMsg(""); 
	
			//Adicionando autenticação no e-mail
			//email.setAuthentication("usuario", "senha");
			//email.setSmtpPort(465);
			//email.setSSL(true);
			//email.setTLS(true);
			
			email.send();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail enviado com sucesso!", null));
		} catch (EmailException e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
}
