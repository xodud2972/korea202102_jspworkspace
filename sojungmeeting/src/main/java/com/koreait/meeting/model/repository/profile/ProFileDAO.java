package com.koreait.meeting.model.repository.profile;

import java.util.List;

import com.koreait.meeting.domain.ProFile;

public interface ProFileDAO {
	public List selectAll();
	public ProFile select(int profile_id);
	public void insert(ProFile proFile);
	public void update(ProFile proFile);
	public void delete(int profile_id);
	public List selectBySignUp(int sign_id);
	
	
}
