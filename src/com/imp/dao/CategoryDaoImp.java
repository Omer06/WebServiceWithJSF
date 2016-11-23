package com.imp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.entities.Book;
import com.entities.Category;
import com.interfaces.dao.CategoryDao;

@Repository
public class CategoryDaoImp implements CategoryDao {

	@Autowired
	@Qualifier("sessionFactoryImp")
	SessionFactory sessionFactory;

	@Override
	public List<Category> getList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from category").list();
	}

	@Override
	public void save(Category entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void saveOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Category getBy(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public void update(Category entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public Category getBy(int categoryId, boolean hasUserBook) {
		
		Category category = sessionFactory.getCurrentSession().get(Category.class, categoryId);
		
		List<Book> bookList = null;
		
		if(hasUserBook)
		bookList = sessionFactory.getCurrentSession()
									 .createCriteria(Book.class)
									 .add(Restrictions.eq("category_id", categoryId))
									 .list();

		category.setBookList(bookList);
		return category;
	}

}
