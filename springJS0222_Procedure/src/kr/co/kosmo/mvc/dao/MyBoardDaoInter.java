package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.BoardVO;
import kr.co.kosmo.mvc.vo.PagingDTO;

public interface MyBoardDaoInter {

	public void addBoard(BoardVO vo);
	public List<BoardVO> listBoard();
	public List<BoardVO> searchlistBoard(PagingDTO pvo);
	public int getCnt(PagingDTO pvo);
	public BoardVO detailBoard(int num);
	public void delBoard(int num);
	public void upBoard(BoardVO vo);
	
	
	
}
