package com.koreait.meeting.model.repository.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.meeting.domain.Admin;
import com.koreait.meeting.exception.MemberExistException;


@Repository
public class MybatisAdminDAO implements AdminDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Admin login(Admin admin) throws MemberExistException {
		Admin obj=sqlSessionTemplate.selectOne("Admin.login", admin);
		if(obj==null) {
			throw new MemberExistException("로그인 정보가 올바르지 않습니다");
		}
		//아이디와 패스워드가 일치하지 않을경우 우리가 원하는 경우가 나오지 않기에
		//exception객체 만들기 
		return obj;
	}
	@Override
	public void regist(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
