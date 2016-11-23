package com.imp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.entities.Book;
import com.interfaces.dao.BookDao;

@Repository
public class BookDaoImp implements BookDao {
	
	@Autowired
	@Qualifier("sessionFactoryImp")
	SessionFactory sessionFactory;

	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("book.getList").list();
	}

	@Override
	public void save(Book entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Book entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void saveOrUpdate(Book entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public Book getBy(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public void update(Book entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public List<Book> getListBy(int categoryId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Book.class).add(Restrictions.eq("category_id", categoryId)).list();
	}

}
