package kr.co.kosmo.mvc.controller.chart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

//@Controller 스프링 컨테이너ㅣ가 Model로 선택해서
// 현재 시스템에서는 ViewResolver를 통해서 지정
//<!-- View타입 => viewResolver 설정 /WEB-INF/views/[hello].jsp class => InternalResourceViewResolver -->
//View로 지정한 forward방식으로 이동한다.
//@RestController -> CustomView를 사용해서 지정한 View 즉, JSP를 사용하지 않고 데이터를 응답할 수 있기 때문에
// 주로 JSON으로 response 할 때 주로 사용함
@RestController
public class ChartRestController {
// 해당 요청이 오면 가상 View에 반환받은 값을 전달해서 응답처리를 해준다.
	@Autowired
	public MemberDaoInter memberDaoInter;

	
	//produces = "text/html;charset=euc-kr" => Context-Type을 지정하는 속성
	@RequestMapping(value = "/helloView", produces = "text/html;charset=euc-kr")
	public String veiwMessage() {
		return "안녕하세요";
	}
	
	//Json ObjectType -> javaScript Object
	@RequestMapping(value = "/deptJsonView1", produces = "application/json;charset=utf-8")
	public MemberDTO jsonObjectDemo1(String id) {
		
		try {
			MemberDTO vo = memberDaoInter.jsonDemo(id);
			System.out.println("id=>"+id);
			return vo;
		} catch (Exception e) {
			MemberDTO vo = new MemberDTO();
			vo.setName("없음");
			System.out.println("name=>"+vo.getName());
			return vo;
		}
		
		/*
		System.out.println("id=>"+id);
		MemberDTO vo = new MemberDTO();
		vo.setName("이봄");
		vo.setNum(1);
		vo.setAge(19);
		vo.setGender("남자");
		vo.setId("spring2");
		vo.setPwd("123");
		vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		//결과확인
		//{"num":1,"age":19,"id":"Spring2","name":"이봄",
		//"gender":"남자","pwd":"123","mdate":"2023-01-18"}
		return vo;
		*/
	}
	
	//연습문제1 : 회원 전체를 출력하는 JsonView를 만드시오
	@GetMapping(value = "deptJsonView2", produces = "application/json;charset=utf-8")
	public List<MemberDTO> jsonObjectDemolist() {
		List<MemberDTO> list = memberDaoInter.jsonDemolist();
		return list;
	}
	
	//연습문제 2: 회원 전체를 출력하는 js 페이징이 된  JsonView를 만드시오
	//public PagingDTO 

	
}
