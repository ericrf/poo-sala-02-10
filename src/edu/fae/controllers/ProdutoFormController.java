package edu.fae.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.UploadedFile;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.dao.PalavraChaveDao;
import edu.fae.dao.ProdutoDao;
import edu.fae.model.Categoria;
import edu.fae.model.Endereco;
import edu.fae.model.Imagem;
import edu.fae.model.PalavraChave;
import edu.fae.model.Produto;
import edu.fae.util.DualListModelDiff;
import edu.fae.util.IOUtil;
import edu.fae.util.ThumbnailHelper;

@ViewScoped
@ManagedBean(name="produtoFormController")
public class ProdutoFormController {
	private ProdutoDao produtoDao = DaoFactory.getProdutoDao();
	private CategoriaDao categoriaDao = DaoFactory.getCategoriaDao();
	private PalavraChaveDao palavraChaveDao = DaoFactory.getPalavraChaveDao();
	 private UploadedFile fileImagemChamada;
	 
	 

	/**
	 * Objeto produto que é editado no formulário
	 */
	private Produto produto;

	
	
	public Object getFileImagemChamada() {
		return fileImagemChamada;
	}
	public void setFileImagemChamada(Object obj) {
		if(obj instanceof UploadedFile) {
			this.fileImagemChamada = (UploadedFile) obj;
		}else{
			this.fileImagemChamada = null;
		}
	}    
    
	
	
	/**
	 * Este método é chamado quando a página do formulário é aberta
	 */
	@PostConstruct
	public void iniciar() {
		//Pegando o parâmetro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {//Quando o id está null, abrimos o formulário para inserção
			produto = new Produto();
			produto.setEndereco(new Endereco());
		}else{//Quando o id é passado como parâmetro abrimos o formulário para edição
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
		
	if(fileImagemChamada!=null) {
			
			//Grava na propriedade imagemChamada o nome do arquivo
		getProduto().setImagemChamada(fileImagemChamada.getFileName());
			
			try {
				//Pega o caminho real no servidor da pasta imagens do projeto
				String caminhoImagens = getRealServerPath("/imagens");
				
				
				//Salva o arquivo na pasta imagens do projeto
				FileOutputStream fout = new FileOutputStream(caminhoImagens + 
							File.separator + fileImagemChamada.getFileName());
				
				//Gera uma imagem do tamanho exato 150x150
				ThumbnailHelper.gerarTamanhoExato(fileImagemChamada.getInputstream(), 
													fout, 150, 150, 90, false);
				
				//Gera uma imagem do tamanho exato 150x150 e em preto e branco
//				ThumbnailHelper.gerarTamanhoExato(fileImagemChamada.getInputstream(), 
//						fout, 150, 150, 90, false);				
				
				//Gera uma imagem de tamanho proprocional, colocando ou a altura ou largura em 150px
//				ThumbnailHelper.gerarProprocional(fileImagemChamada.getInputstream(), 
//						fout, 150, 150, 90, false);							
				
				//IOUtil.copyStream(fileImagemChamada.getInputstream(), fout);
	
				
				//Chama o produtoDao para salvar o objeto Produto
				produtoDao.save(produto);
				
				//Mandando uma mensagem para a tela
				FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto salvo com sucesso!" + getRealServerPath(""), null)
				);
				
			} catch (Exception e) {
				System.out.println("Ocorreu um erro ao salvar o arquivo do upload");
				e.printStackTrace();
			}
			
		}


	
	}
	
	private String getRealServerPath(String caminhoRelativo) {
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath(caminhoRelativo);
	}	

	
	public void uploadGaleria(FileUploadEvent event) {
		try {
			
			//Pega o caminho real no servidor da pasta imagens do projeto
			String caminhoImagens = getRealServerPath("/imagens");
			
			//Salva o arquivo na pasta imagens do projeto
			FileOutputStream fout = new FileOutputStream(caminhoImagens 
						+ File.separator + event.getFile().getFileName());
			IOUtil.copyStream(event.getFile().getInputstream(), fout);
			
			//Cria uma nova imagem e adiciona no conteúdo
			Imagem imagem = new Imagem();
			//Seta o nome do arquivo na imagem
			imagem.setArquivo(event.getFile().getFileName());
			//Adiciona a imagem no conteúdo
			getProduto().getImagens().add(imagem);
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao salvar o arquivo do upload");
			throw new RuntimeException(e);
		}			
		
	}	
	
}
