package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.fae.model.Model;

public abstract class AbstractDaoHibernate<MODEL extends Model> {

	public List<MODEL> findAll() {
		//Busca a sessão do Hibernate getSession()
		//Cria um HQL para buscar os usuário
		//E retorna uma lista com o resultado da consulta HQL
		return getSession().createQuery("from "+getModelClassName()).list();
	}
	
	public MODEL findById(Long id) {
		//Cria a consulta de Usuario por id
		Query query = getSession().createQuery("from "+getModelClassName()+" where id=:id");
		//Seta o parâmetro id
		query.setLong("id", id);
		//Executa a consulta retornando um resultado apenas
		return (MODEL) query.uniqueResult();
	}	
	
	public void save(MODEL model) {
		//Salva o usuário
		//Faz as operação de update e insert
		//update quando o objeto tem id
		//insert quando o objeto não tem id
		getSession().saveOrUpdate(model);
	}
	
	
	public void remove(MODEL model) {
		//Remove o usuário da base de dados
		getSession().delete(model);
	}
	
	
	protected abstract String getModelClassName();
	
	protected Session getSession() {
		return HibernateUtil.getSession();
	}
}
