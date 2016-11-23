package com.interfaces.dao;

import com.entities.Category;

public interface CategoryDao extends EntityDao<Category>{ 
	
	public Category getBy(int categoryId , boolean hasUserBook);
	
}
