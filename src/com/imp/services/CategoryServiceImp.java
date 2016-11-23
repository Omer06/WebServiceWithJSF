package com.imp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entities.Category;
import com.interfaces.dao.CategoryDao;
import com.interfaces.services.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	@Qualifier("categoryDaoImp")
	CategoryDao categoryDao;
	
	@Override
	public List<Category> getList() {
		// TODO Auto-generated method stub
		return categoryDao.getList();
	}

	@Override
	public void save(Category entity) {
		// TODO Auto-generated method stub
		categoryDao.save(entity);
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		categoryDao.delete(entity);
	}

	@Override
	public void saveOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		categoryDao.saveOrUpdate(entity);
	}

	@Override
	public Category getBy(int id) {
		// TODO Auto-generated method stub
		return categoryDao.getBy(id);
	}

	@Override
	public void update(Category entity) {
		// TODO Auto-generated method stub
		categoryDao.update(entity);
	}

	@Override
	public Category getBy(int categoryId, boolean hasUserBook) {
		// TODO Auto-generated method stub
		return categoryDao.getBy(categoryId, hasUserBook);
	}

}
