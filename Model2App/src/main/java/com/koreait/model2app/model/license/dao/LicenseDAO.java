package com.koreait.model2app.model.license.dao;

import java.util.List;

import com.koreait.model2app.model.domain.License;

public interface LicenseDAO {
	public int insert(License license);//등록
	public List selectAll();//리스트
	public License select(int license_id);//한건가져오기
	public int update(License license);//수정
	public int delete(int license_id);//삭제
}
