package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.Dao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Categoria;
import edu.fae.model.Model;

@ViewScoped
@ManagedBean(name = "categoriaFormController")
public class AbstractFormController<MODEL extends Model, DAO extends Dao<MODEL>> {
	private DAO dao = getDao();// DaoFactory.getCategoriaDao();

	protected DAO getDao() {
		return null;
	}

	/**
	 * Objeto categoria que � editado no formul�rio
	 */
	private MODEL model;

	/**
	 * Este m�todo � chamado quando a p�gina do formul�rio � aberta
	 */
	@PostConstruct
	public void iniciar() {
		// Pegando o par�metro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		if (id == null) {// Quando o id est� null, abrimos o formul�rio para
							// inser��o
			model = getNewModel();
		} else {// Quando o id � passado como par�metro abrimos o formul�rio
				// para edi��o
			model = dao.findById(new Long(id));
		}
	}

	protected  MODEL getNewModel() {
		return null;
	}
	
	public MODEL getModel() {
		return model;
	}

	public void salvar() {
		// Pegamos uma referencia para o FacesContext, para mandar mensagens
		// para a tela
		FacesContext ctx = FacesContext.getCurrentInstance();

		dao.save(model);

		// Mandando uma mensagem para a tela
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Registro salvo com sucesso!", null));
	}

}
