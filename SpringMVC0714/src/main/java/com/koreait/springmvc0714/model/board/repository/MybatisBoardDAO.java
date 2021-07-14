package com.koreait.springmvc0714.model.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.domain.Board;
import com.koreait.springmvc0714.model.mybatis.MybatisConfigManager;

import lombok.Setter;

@Setter
public class MybatisBoardDAO implements BoardDAO{
	private MybatisConfigManager configManager;
	
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List boardList = sqlSession.selectList("Board.selectAll");//쿼리 수행 후 List 반환 받기
		configManager.closeSession(sqlSession);
		return boardList;
	}

	@Override
	public void insert(Board board) throws DMLException{ //여기서 에러를 처리해버리면, 
		//미궁에 빠짐..뷰단까지 에러의 원인을 전달해야 한다..그래야 사용자들이 에러가 낫음을 이해하고, 개발자는
		//적절한 에러 처리를 할 수 있다..(에러페이지로 이동)
		SqlSession sqlSession = configManager.getSession();
		int result=sqlSession.insert("Board.insert", board); //에러가 날수도 잇다..비정상종료가 됨을 방지
		sqlSession.commit();//DML
		configManager.closeSession(sqlSession);
		
		if(result==0) {
			throw new DMLException("등록실패");
		}
	}

	@Override
	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		Board board = sqlSession.selectOne("Board.select", board_id); //한건 가져오기
		configManager.closeSession(sqlSession);
		return board;
	}

	@Override
	public void update(Board board) throws DMLException{
		SqlSession sqlSession = configManager.getSession();
		int result=sqlSession.update("Board.update", board);
		sqlSession.commit(); //DML
		configManager.closeSession(sqlSession);
		
		if(result==0) {
			throw new DMLException("수정 실패");
		}
	}

	@Override
	public void delete(int board_id) throws DMLException{
		SqlSession sqlSession = configManager.getSession();
		int result=sqlSession.delete("Board.delete", board_id);
		sqlSession.commit(); //DML
		configManager.closeSession(sqlSession);
		
		if(result==0) {
			throw new DMLException("삭제 실패");
		}
	}
	
}
