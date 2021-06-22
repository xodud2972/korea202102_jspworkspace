package com.koreait.site0622.model.member.dao;

import java.util.List;

import com.koreait.site0622.model.domain.Member;

public interface MemberDAO {
	public Member getMemberById(String id); //아이디를 통해 해당 회원이 존재하는지 체크하기위한 메서드 정의
	
	public int regist(Member member);//회원가입
	public int delete(Member member);//회원삭제
	public List selectAll(); //회원목록
	public Member Select(int member_id);// 회원정보 1건 가져오기
	public int update(Member member);//회원수정
	

}
