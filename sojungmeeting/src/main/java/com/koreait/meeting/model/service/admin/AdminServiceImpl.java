package com.koreait.meeting.model.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.koreait.meeting.domain.Admin;
import com.koreait.meeting.exception.MemberExistException;
import com.koreait.meeting.model.repository.admin.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO adminDAO;
	
	
	@Override
	public Admin login(Admin admin) throws MemberExistException{
		return adminDAO.login(admin);
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
