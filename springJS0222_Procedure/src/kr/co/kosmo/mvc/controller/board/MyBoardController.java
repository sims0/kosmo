package kr.co.kosmo.mvc.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MyBoardDaoInter;
import kr.co.kosmo.mvc.vo.BoardVO;
import kr.co.kosmo.mvc.vo.PagingDTO;

@Controller
@RequestMapping(value = "/board") // 대분류
public class MyBoardController {

	@Autowired
	private MyBoardDaoInter myBoardDaoInter;
	//===
	private int nowPage = 1; // 현재 페이지 값 -> 메뉴 페이지와 연동되는 변수
	private int nowBlock = 1; // 현재 블럭 -> [][][][][] -> 1block당 5개 배열 생성
	private int totalRecord; // 총 게시물 수 .Dao로 부터 받음
	private int numPerPage = 10; // 한 페이지당 보여질 게시물 수
	private int pagePerBlock = 5; // 한 블럭당 보여질 페이지 수
	private int totalPage; // 전체 페이지 수 => totalRecord/numPerPage
	private int totalBlock; // 전체 블럭수
	private int beginPerPage; // 각 페이지별 시작 게시물의 index값
	private int endPerPage; // 각 페이지별 마지막 게시물의 index값

	@GetMapping(value = "/boardForm")
	public ModelAndView boardForm() {
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}

	@PostMapping(value = "/boardIn")
	public String boardIn(BoardVO vo) {
		System.out.println("subject=>" + vo.getSubject());
		System.out.println("contents" + vo.getContents());
		// private String reip, title, subject, contents, content, writer, bdate;
		// private int num;
		myBoardDaoInter.addBoard(vo);
		return "redirect:/web/board/boardList";
	}

	@GetMapping(value = "/boardList")
	public ModelAndView listBoard() {
		// 페이지 이동방식 1
		ModelAndView mav = new ModelAndView("board/boardList");
		List<BoardVO> list = myBoardDaoInter.listBoard();
		// 이동방식의 디폴트값은 forward
		mav.addObject("list", list);
		// setAttribute랑 같은 효과 이동하는 페이지로 addObject한 값을 보낸다.
		// (key를 사용하여 value호출)
		// mav.setView("board/boardList");
		return mav;
	}
	
	@GetMapping(value = "/boardDetail")
	public ModelAndView detailBoard(int num) {
		ModelAndView mav = new ModelAndView("board/boardDetail");
		BoardVO vo = myBoardDaoInter.detailBoard(num);
		mav.addObject("vo", vo);
		return mav;
	}

	@GetMapping(value = "/boardDelete")
	public String deleteBoard(int num) {
		myBoardDaoInter.delBoard(num);
		return "redirect:/web/board/boardList";
	}

	@GetMapping(value = "/boardUpForm")
	public ModelAndView boardUpForm(int num) {
		ModelAndView mav = new ModelAndView("board/boardUpForm");
		BoardVO vo = myBoardDaoInter.detailBoard(num);
		mav.addObject("vo", vo);
		return mav;
	}

	@PostMapping(value = "/boardUp")
	public String upBoard(BoardVO vo) {
		int num = vo.getNum();
		myBoardDaoInter.upBoard(vo);
		return "redirect:/web/board/boardList";
	}
	
	@GetMapping(value = "/boardSearchList")
	public ModelAndView SearchlistBoard(String cPage, PagingDTO pvo) {
		totalRecord = myBoardDaoInter.getCnt(pvo);

		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;

		pvo.setBegin(beginPerPage);
		pvo.setEnd(endPerPage);
		
		ModelAndView mav = new ModelAndView("board/boardSearchList");
		List<BoardVO> list = myBoardDaoInter.searchlistBoard(pvo);
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		
		mav.addObject("list", list);
		mav.addObject("nowPage", nowPage);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("pagePerBlock", pagePerBlock);
		mav.addObject("totalPage", totalPage);
		mav.addObject("SearchType",pvo.getSearchType());
		mav.addObject("SearchValue",pvo.getSearchValue());
		
		return mav;
	}
}
