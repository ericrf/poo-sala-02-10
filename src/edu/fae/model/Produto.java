package edu.fae.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto implements Model {

	private static final long serialVersionUID = 5969039284795659997L;
	private Long id;
	private String nome;
	private String marca;
	private String cor;
	private Date data;
	private String descricao;
	private Endereco endereco;
	private Categoria categoria;
	private double valor;
	private List<PalavraChave> palavrasChave = new ArrayList<PalavraChave>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 150)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Size(min = 2, max = 14, message="A marca deve ter entre 2 e 14 carateres")
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@NotNull
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Valid
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@NotNull(message="Informe a categoria do produto")
	@ManyToOne(fetch=FetchType.LAZY)
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	public List<PalavraChave> getPalavrasChave() {
		return palavrasChave;
	}
	public void setPalavrasChave(List<PalavraChave> palavrasChave) {
		this.palavrasChave = palavrasChave;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
