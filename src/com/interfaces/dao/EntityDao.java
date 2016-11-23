package com.interfaces.dao;

import java.util.List;

import com.entities.Category;


public interface EntityDao<T> {
	
	public List<T> getList();
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public void saveOrUpdate(T entity);
	
	public T getBy(int id);
	
	public void update(T entity);

}
