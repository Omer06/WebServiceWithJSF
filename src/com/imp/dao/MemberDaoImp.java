package com.imp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.entities.Category;
import com.entities.Member;
import com.interfaces.dao.MemberDao;

@Repository
public class MemberDaoImp implements MemberDao{
	
	@Autowired
	@Qualifier("sessionFactoryImp")
	SessionFactory sessionFactory;

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		List<Member> member = sessionFactory.getCurrentSession().createQuery("from member").list();
		
		member.forEach(argMember -> System.out.println(argMember));
		System.out.println("Size : " + member.size());
		return member;
	}

	@Override
	public void save(Member entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Member entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void saveOrUpdate(Member entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public Member getBy(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Member.class, id);
	}

	@Override
	public void update(Member entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

}
