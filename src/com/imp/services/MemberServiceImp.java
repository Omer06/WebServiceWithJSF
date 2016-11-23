package com.imp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entities.Member;
import com.interfaces.dao.MemberDao;
import com.interfaces.services.MemberService;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	@Qualifier("memberDaoImp")
	MemberDao memberDao;

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return memberDao.getList();
	}

	@Override
	public void save(Member entity) {
		// TODO Auto-generated method stub
		memberDao.save(entity);
	}

	@Override
	public void delete(Member entity) {
		// TODO Auto-generated method stub
		memberDao.delete(entity);
	}

	@Override
	public void saveOrUpdate(Member entity) {
		// TODO Auto-generated method stub
		memberDao.saveOrUpdate(entity);
	}

	@Override
	public Member getBy(int id) {
		// TODO Auto-generated method stub
		return memberDao.getBy(id);
	}

	@Override
	public void update(Member entity) {
		// TODO Auto-generated method stub
		memberDao.update(entity);
	}

}
