package com.koreait.meeting.model.service.profile;

import java.util.List;

import com.koreait.meeting.domain.ProFile;

public interface ProFileService {
	public List selectAll();
	public ProFile select(int profile_id);
	public void regist(ProFile proFile);
	public void update(ProFile proFile);
	public void delete(int profile_id);
	public List selectBySignUp(int sign_id);
	

}
