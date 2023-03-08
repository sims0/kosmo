package kr.co.kosmo.mvc.controller.exam;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

@Controller
@RequestMapping(value = "/mywork")
public class JsonListPageController {
	@Autowired
	private MemberDaoInter memberDaoInter;
	//-----------------
		private int nowPage = 1; // 현재 페이지 값 -> 하단의 메뉴페이지와 연동되는 변수
		private int nowBlock = 1; // 현재 블럭 -> [][][][][] -> 1block
		private int totalRecord; // 총 게시물 수 -> .Dao로부터 받음
		private int numPerpage = 10; // 한 페이지당 보여질 게시물 수
		private int pagePerBlock = 5; // 한 블럭당 보여질 게시물 수 => 한 블럭당 보여질 페이지의 수
		private int totalPage; // 전체 페이지수=>totalRecord/numPerpage
		private int totalBlock; // 전체 블럭 수
		private int beginPerPage; // 각 페이지별 시작 게시물의 index값 =>rownum
		private int endPerPage; // 각 페이지별 마지막 게시물의 index값 =>rownum

		//-----------------
		
		@GetMapping(value = "/jsonpagelist")
		public String memberPageJsonDemo(String cPage, Map<String, Integer> map) {
			totalRecord = memberDaoInter.jsonCnt();
			totalPage = (int) Math.ceil(totalRecord / (double) numPerpage);
			totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
			String s_page = cPage;
			if (s_page != null) {
				nowPage = Integer.parseInt(s_page);
			}
			beginPerPage = (nowPage - 1) * numPerpage + 1;
			endPerPage = (beginPerPage - 1) + numPerpage;
			map.put("begin", beginPerPage);
			map.put("end", endPerPage);
			
			List<MemberDTO> list = memberDaoInter.jsonPagelist(map); 
			
			int startPage = (int) (nowPage - 1) / pagePerBlock * pagePerBlock + 1;
			int endPage = startPage + pagePerBlock - 1;
			if (endPage > totalPage) {
				endPage = totalPage;
			}
			
			/*
			request.setAttribute("list", list);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("startPage", startPage); // 미정
			request.setAttribute("endPage", endPage); // 미정
			request.setAttribute("pagePerBlock", pagePerBlock); // 설정값:5
			request.setAttribute("totalPage", totalPage);   */
			
			return "chart/memberPageJson";
		}
}
