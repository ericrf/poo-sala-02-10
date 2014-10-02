package edu.fae.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.dao.PalavraChaveDao;
import edu.fae.dao.ProdutoDao;
import edu.fae.model.Categoria;
import edu.fae.model.Endereco;
import edu.fae.model.PalavraChave;
import edu.fae.model.Produto;
import edu.fae.util.DualListModelDiff;

@ViewScoped
@ManagedBean(name="produtoFormController")
public class ProdutoFormController {
	private ProdutoDao produtoDao = DaoFactory.getProdutoDao();
	private CategoriaDao categoriaDao = DaoFactory.getCategoriaDao();
	private PalavraChaveDao palavraChaveDao = DaoFactory.getPalavraChaveDao();

	/**
	 * Objeto produto que � editado no formul�rio
	 */
	private Produto produto;

	/**
	 * Este m�todo � chamado quando a p�gina do formul�rio � aberta
	 */
	@PostConstruct
	public void iniciar() {
		//Pegando o par�metro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {//Quando o id est� null, abrimos o formul�rio para inser��o
			produto = new Produto();
			produto.setEndereco(new Endereco());
		}else{//Quando o id � passado como par�metro abrimos o formul�rio para edi��o
			produto = produtoDao.findById(new Long(id));
			if(produto.getEndereco()==null) {
				produto.setEndereco(new Endereco());
			}
		}
	}
	public Produto getProduto() {
		return produto;
	}
	
	public List<Categoria> getCategorias() {
		return categoriaDao.findAll();
	}
	
	public DualListModel<PalavraChave> getProdutoPalavrasChave() {
		return new DualListModelDiff<PalavraChave>(palavraChaveDao.findAll(), getProduto().getPalavrasChave());
	}	
	public void setProdutoPalavrasChave(DualListModel<PalavraChave> palavras) {
		getProduto().setPalavrasChave(palavras.getTarget());
	}
	
	public void salvar() {

		//Chama o produtoDao para salvar o objeto Produto
		produtoDao.save(produto);
		
		//Mandando uma mensagem para a tela
		FacesContext.getCurrentInstance().addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto salvo com sucesso!", null)
		);
	}
	

}
