package com.koreait.meeting.model.repository.profile;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.meeting.domain.ProFile;
import com.koreait.meeting.exception.DMLException;

@Repository
public class MybatisProFileDAO implements ProFileDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List selectAll() {
		return sqlSessionTemplate.selectList("ProFile.selectAll");
	}

	public ProFile select(int profile_id) {
		return sqlSessionTemplate.selectOne("ProFile.select", profile_id);
	}

	public void insert(ProFile proFile) throws DMLException{
		System.out.println("프로필 드록 전 sign_id "+proFile.getSign_id());
		
		int result = sqlSessionTemplate.insert("ProFile.insert", proFile);
		if(result==0) {
			throw new DMLException("프로필 등록에 실패하였습니다.");
		}
	}


	public void update(ProFile proFile) throws DMLException{
		int result = sqlSessionTemplate.update("ProFile.update", proFile);
		if(result==0) {
			throw new DMLException("프로필 수정에 실패하였습니다.");
		}
	}

	public void delete(int profile_id) throws DMLException{
		int result = sqlSessionTemplate.delete("ProFile.delete", profile_id);
		if(result==0) {
			throw new DMLException("프로필 삭제에 실패하였습니다.");
		}
	}

	public List selectBySignUp(int sign_id) {
		return sqlSessionTemplate.selectList("ProFile.selectBySignUp", sign_id);
	}

}
