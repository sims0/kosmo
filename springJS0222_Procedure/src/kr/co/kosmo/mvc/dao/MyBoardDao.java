package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.BoardVO;
import kr.co.kosmo.mvc.vo.PagingDTO;

@Repository
public class MyBoardDao implements MyBoardDaoInter {
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addBoard(BoardVO vo) {
		ss.insert("myboard.add", vo);
	}

	@Override
	public List<BoardVO> listBoard() {
		List<BoardVO> list = ss.selectList("myboard.list");
		return list;
	}

	@Override
	public BoardVO detailBoard(int num) {
		BoardVO vo = ss.selectOne("myboard.detail", num);
		return vo;
	}

	@Override
	public void delBoard(int num) {
		ss.delete("myboard.delete", num);
	}

	@Override
	public void upBoard(BoardVO vo) {
		ss.selectOne("myboard.up", vo);
	}

	@Override
	public List<BoardVO> searchlistBoard(PagingDTO pvo) {
		return ss.selectList("myboard.listSearchPage", pvo);
	}

	@Override
	public int getCnt(PagingDTO pvo) {
		return ss.selectOne("myboard.searchCount", pvo);
	}

	

}
