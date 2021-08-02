package com.koreait.meeting.model.repository.admin;

import java.util.List;

import com.koreait.meeting.domain.Admin;

public interface AdminDAO {
	public Admin login(Admin admin); //로그인
	public void regist(Admin admin); // 관리자 등록
	public void update(Admin admin); // 관리자 수정
	public void delete(Admin admin); // 아이디, 패스워드 모두 일치할때 탈퇴시켜야 하기 떄문,..
	public List selectAll();
}
