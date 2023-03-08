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
		private int nowPage = 1; // ���� ������ �� -> �ϴ��� �޴��������� �����Ǵ� ����
		private int nowBlock = 1; // ���� �� -> [][][][][] -> 1block
		private int totalRecord; // �� �Խù� �� -> .Dao�κ��� ����
		private int numPerpage = 10; // �� �������� ������ �Խù� ��
		private int pagePerBlock = 5; // �� ���� ������ �Խù� �� => �� ���� ������ �������� ��
		private int totalPage; // ��ü ��������=>totalRecord/numPerpage
		private int totalBlock; // ��ü �� ��
		private int beginPerPage; // �� �������� ���� �Խù��� index�� =>rownum
		private int endPerPage; // �� �������� ������ �Խù��� index�� =>rownum

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
			request.setAttribute("startPage", startPage); // ����
			request.setAttribute("endPage", endPage); // ����
			request.setAttribute("pagePerBlock", pagePerBlock); // ������:5
			request.setAttribute("totalPage", totalPage);   */
			
			return "chart/memberPageJson";
		}
}
