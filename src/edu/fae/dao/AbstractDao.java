package edu.fae.dao;

public interface AbstractDao<T, ID>{
	
	public void save(T t);
	public void persist(T t);
	public void merge(T t);
	public void remove(T t);
	public void find(ID id);
	public void findAll();
}
