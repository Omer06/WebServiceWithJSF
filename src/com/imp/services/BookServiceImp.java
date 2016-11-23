package com.imp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entities.Book;
import com.interfaces.dao.BookDao;
import com.interfaces.services.BookService;

@Service
public class BookServiceImp implements BookService{

	@Autowired
	@Qualifier("bookDaoImp")
	BookDao bookDao;
	
	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		return bookDao.getList();
	}

	@Override
	public void save(Book entity) {
		// TODO Auto-generated method stub
		bookDao.save(entity);
	}

	@Override
	public void delete(Book entity) {
		// TODO Auto-generated method stub
		bookDao.delete(entity);
	}

	@Override
	public void saveOrUpdate(Book entity) {
		// TODO Auto-generated method stub
		bookDao.saveOrUpdate(entity);
	}

	@Override
	public Book getBy(int id) {
		// TODO Auto-generated method stub
		return bookDao.getBy(id);
	}

	@Override
	public void update(Book entity) {
		// TODO Auto-generated method stub
		bookDao.update(entity);
	}

	@Override
	public List<Book> getListBy(int categoryId) {
		// TODO Auto-generated method stub
		return bookDao.getListBy(categoryId);
	}

}
