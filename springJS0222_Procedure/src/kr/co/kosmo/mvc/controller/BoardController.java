package kr.co.kosmo.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.vo.BoardVO;

@Controller
public class BoardController {

	// 1. boardForm
	@GetMapping(value = "/boardForm")
	public ModelAndView boardForm() {
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}

	// 2.boardIn
	/*
	 * ModelAndView mav = new ModelAndView("redirect:boardlist");
	 * sout("reip:"+vo.getReip()); sout("title:"+vo.getTitle());
	 * sout("content:"+vo.getContent());
	 */
	@RequestMapping(value = "/boardIn")
	public ModelAndView boardIn(BoardVO vo) {
		ModelAndView mav = new ModelAndView("redirect:boardlist");
		System.out.println("reip:" + vo.getReip());
		System.out.println("title" + vo.getTitle());
		System.out.println("content" + vo.getContents());
		mav.addObject("vo", vo);
		return mav;
	}

	// 3. boardList List<boardVO> list = new ArrayList<boardVo>(); 임시데이터 만들어서 보내기
	@RequestMapping(value = "/boardlist")
	public String boardList(Model model) {
		//Dao와 연동
		List<BoardVO> list = new ArrayList<BoardVO>();
		//임시 데이터 만들기
		for (int i = 0; i < 20; i++) {
			BoardVO vo = new BoardVO();
			vo.setNum(i + 1);
			vo.setTitle("제목=제목=제목=제목=제목=제목" + i);
			vo.setWriter("김봄");
			vo.setBdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			
			list.add(vo);
		}
		model.addAttribute("list", list);
		return "board/boardList";
	}
	
	
}
