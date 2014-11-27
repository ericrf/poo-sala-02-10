package edu.fae.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imagem implements Model {
	private Long id;
	private String arquivo;
	private String legenda;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public String getArquivo() {
		return arquivo;
	}
	public String getLegenda() {
		return legenda;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}
	
	
	
}
