package com.koreait.model2app.model.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.model2app.model.domain.Board;
import com.koreait.model2app.model.mybatis.MybatisConfigManager;

public class MybatisBoardDAO implements BoardDAO{
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	
	@Override
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("Board.selectAll");
		configManager.closeSession(sqlSession);
		
		return list;
	}

	@Override
	public int insert(Board board) {
		SqlSession sqlSession = configManager.getSession();
		int result=sqlSession.insert("Board.insert", board);
		sqlSession.commit(); //DML
		configManager.closeSession(sqlSession);
		return result;
	}

	@Override
	public Board select(int board_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int board_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
