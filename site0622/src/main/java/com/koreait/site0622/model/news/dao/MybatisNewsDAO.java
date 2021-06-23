package com.koreait.site0622.model.news.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.domain.News;
import com.koreait.site0622.model.mybatis.MybatisConfigManager;

public class MybatisNewsDAO implements NewsDAO{

	MybatisConfigManager ConfigManager = MybatisConfigManager.getInstance();
	
	public int insert(News news) {
		SqlSession sqlSession = ConfigManager.getSession();
		int result = sqlSession.insert("News.insert", news);
		sqlSession.commit(); //DML
		ConfigManager.closeSession(sqlSession);
		return result;
	}

	@Override
	public List selectAll() {
		SqlSession sqlSession = ConfigManager.getSession();
		List list = sqlSession.selectList("News.selectAll");
		ConfigManager.closeSession(sqlSession);
		return list;
	}

	@Override
	public News select(int News_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(News news) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(News news) {
		// TODO Auto-generated method stub
		return 0;
	}

}
