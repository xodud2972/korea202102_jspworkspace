package com.koreait.site0622.model.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.domain.Board;
import com.koreait.site0622.model.mybatis.MybatisConfigManager;

// mybatis 를 이용한다고 하여 DAO가 사라지는게 아니라, DAO의 역할은 그래도 유지된다.
// 단, DAO가 사용하려는는 기술이 JDBC, Mybatis, Hibernate, JPA 등등.. 인것 뿐이다.
public class MybatisBoardDAO implements BoardDAO{
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	
	//등록
	public int insert(Board board) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.insert("Board.insert",board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}
	
	//모든 레코드 가져오기
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("Board.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}
	
	// 한 건 가져오기
	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		Board board =sqlSession.selectOne("Board.select", board_id);
		configManager.closeSession(sqlSession);
		return board;
	}
	
	// 한 건 수정하기
	public int update(Board board) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.update("Board.update", board);
		sqlSession.commit(); // DML인 경우 commit을 해야한다.
		configManager.closeSession(sqlSession);
		return result;
	}
	
	// 한 건 삭제하기
	public int delete(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.delete("Board.delete", board_id);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
		
	}
}
