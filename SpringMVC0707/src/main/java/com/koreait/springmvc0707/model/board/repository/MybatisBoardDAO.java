package com.koreait.springmvc0707.model.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.springmvc0707.model.domain.Board;
import com.koreait.springmvc0707.model.mybatis.MybatisConfigManager;

import lombok.Setter;

@Setter
public class MybatisBoardDAO implements BoardDAO{
	private MybatisConfigManager configManager;
	
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List boardlist = sqlSession.selectList("Board.selectAll"); // 쿼리 수행 후 반환 받기
		configManager.closeSession(sqlSession);
		return boardlist;
	}

	public void insert() {

		
	}

	@Override
	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		Board Board = sqlSession.selectOne("Board.select", board_id);
		configManager.closeSession(sqlSession);
		return Board;
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int board_id) {
		// TODO Auto-generated method stub
		
	}

}
