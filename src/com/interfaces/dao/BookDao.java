package com.interfaces.dao;

import java.util.List;

import com.entities.Book;

public interface BookDao extends EntityDao<Book>{

	public List<Book> getListBy(int categoryId);
	
}
