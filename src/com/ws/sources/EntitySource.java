package com.ws.sources;

import java.util.List;

import com.entities.OperationResult;

public interface EntitySource<T> {
	
	public List<T> getList();
	
	public T getBy(int entityId);
	
	public OperationResult save(T entity);
	
	public OperationResult delete(int entityId);
	
	public OperationResult update(T entity);
	
}
