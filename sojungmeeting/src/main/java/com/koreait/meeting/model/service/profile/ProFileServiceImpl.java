package com.koreait.meeting.model.service.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.meeting.domain.ProFile;
import com.koreait.meeting.exception.DMLException;
import com.koreait.meeting.model.repository.profile.ProFileDAO;

@Service
public class ProFileServiceImpl implements ProFileService{
	
	@Autowired
	private ProFileDAO proFileDAO;
	
	public List selectAll() {
		return proFileDAO.selectAll();
	}

	public ProFile select(int profile_id) {
		return proFileDAO.select(profile_id);
	}

	public void regist(ProFile proFile) throws DMLException{
		proFileDAO.insert(proFile);
	}

	public void update(ProFile proFile) throws DMLException{
		proFileDAO.update(proFile);;
	}

	public void delete(int profile_id) throws DMLException{
		proFileDAO.delete(profile_id);
	}

	public List selectBySignUp(int sign_id) {
		return proFileDAO.selectBySignUp(sign_id);
	}

}
