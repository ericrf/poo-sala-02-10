package edu.fae.dao;

import java.util.List;

import edu.fae.model.Model;

public interface Dao<MODEL extends Model> {
	/**
	 * Busca todos os usários
	 * 
	 * @return
	 */
	public List<MODEL> findAll();
	
	/**
	 * Salva um usuário. Inserção e alteração
	 * 
	 * @param usuario
	 */
	public void save(MODEL object);
	
	/**
	 * Remove um usuário
	 * @param usuario
	 */
	public void remove(MODEL object);
	
	/**
	 * Procura um usuário por id
	 * @param id 
	 * @return Usuário encontrado
	 */
	public MODEL findById(Long id);
}
