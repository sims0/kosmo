package mobile.kosmo.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.co.kosmo.mvc.vo.UpBoardDTO;
import mobile.kosmo.mvc.dao.UpBoardDaoInter;

@Controller
public class DefaultMobileController {
	private int nowPage = 1; // 현재 페이지 값 -> 메뉴 페이지와 연동되는 변수
	private int nowBlock = 1; // 현재 블럭 -> [][][][][] -> 1block당 5개 배열 생성
	private int totalRecord; // 총 게시물 수 .Dao로 부터 받음
	private int numPerPage = 10; // 한 페이지당 보여질 게시물 수
	private int pagePerBlock = 5; // 한 블럭당 보여질 페이지 수
	private int totalPage; // 전체 페이지 수 => totalRecord/numPerPage
	private int totalBlock; // 전체 블럭수
	private int beginPerPage; // 각 페이지별 시작 게시물의 index값
	private int endPerPage; // 각 페이지별 마지막 게시물의 index값

	@Autowired
	private UpBoardDaoInter upBoardList;

	@RequestMapping(value = { "/", "/main" })
	public String upBoardList(Model model, String cPage) {
		totalRecord = upBoardList.getCnt();
		System.out.println("1. TotalRecord :" + totalRecord);
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage :" + totalPage);

		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		System.out.println("3. totalBlock :" + totalBlock);

		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		System.out.println("4. nowPage :" + nowPage);

		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", beginPerPage);
		map.put("end", endPerPage);

		List<UpBoardDTO> list = upBoardList.getList(map);

		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);

		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pagePerBlock", pagePerBlock); // 설정된 5
		model.addAttribute("totalPage", totalPage);

		//return "updemo/upboardList";
		return "index";
	}
}
