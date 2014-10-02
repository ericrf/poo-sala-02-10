package edu.fae.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Endereco implements Model {
	private Long id;
	private String rua;
	private String bairro;
	private String numero;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 14)	
	public String getRua() {
		return rua;
	}
	public String getBairro() {
		return bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}	
	
}
