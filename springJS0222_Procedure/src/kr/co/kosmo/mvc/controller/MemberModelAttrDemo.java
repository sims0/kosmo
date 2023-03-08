package kr.co.kosmo.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.vo.MemberDemoVO;

@Controller // 중요!!!
public class MemberModelAttrDemo {
	// form을 띄우기 위한 메서드를 정의 - forward

	// @RequestMapping(value = "/memberForm", method = RequestMethod.GET)
	// only Get방식만 지정 spring 4.X만 지원
	@GetMapping(value = "/memberForm")
	public ModelAndView memberform() {
		ModelAndView mav = new ModelAndView("member/memberForm");
		return mav;
	}

	// memberIn 처리하는 메서드와 핸들러 매핑을 정의한다.
	// 파라미터 처리(사용자가 입력한 값) : HttpServletRequest request WAS-> DispatcherServlet
	// -> SpringContainer에 의해서 주입받는다.
	// @PostMapping(value = "/memberIn")
	public ModelAndView addTest(HttpServletRequest request) {
		System.out.println("ID0=>" + request.getParameter("id")); // 세미때 사용했던 방식
		System.out.println("PASSWORD0=>" + request.getParameter("pwd"));
		System.out.println("NAME0=>" + request.getParameter("uname"));
		ModelAndView mav = new ModelAndView("member/success");
		return mav; //setAttribute안해서 jsp에서 안보임?
	}

	// request.getParameter() 안써도 됨. 알아서 파라미터 처리 해줌
//	@PostMapping(value = "/memberIn")
	public ModelAndView addTest(String id, String pwd, String uname) {

		System.out.println("ID=>" + id);
		System.out.println("PASSWORD=>" + pwd);
		System.out.println("NAME=>" + uname);
		ModelAndView mav = new ModelAndView("member/success");
		return mav;

	}

	// vo에 파라미터를 알아서 바인딩해서 저장함!!
	// @PostMapping(value = "/memberIn")
	public ModelAndView addTest(MemberDemoVO vo) {

		System.out.println("ID(VO)=>" + vo.getId());
		System.out.println("PASSWORD(VO)=>" + vo.getPwd());
		System.out.println("NAME(VO)=>" + vo.getUname());
		ModelAndView mav = new ModelAndView("member/success");
		mav.addObject("vo", vo);
		return mav;
	}

//	@PostMapping(value = "/memberIn")
//	public String addTest(Model model, MemberDemoVO vo) {
//
//		System.out.println("@ID(VO)=>" + vo.getId());
//		System.out.println("@PASSWORD(VO)=>" + vo.getPwd());
//		System.out.println("@NAME(VO)=>" + vo.getUname());
//		System.out.println("-----------------");
//		vo.setRdate("2023-01-03");
//		model.addAttribute("vo", vo);
//		ModelAndView mav = new ModelAndView("member/success");
//		mav.addObject("vo",vo);
//		return "member/success";
//	}
	
	@PostMapping(value = "/memberIn")
	public String addTest(Model model, @ModelAttribute(value = "vo") MemberDemoVO vo) {
		
		System.out.println("@ID(VO)=>" + vo.getId());
		System.out.println("@PASSWORD(VO)=>" + vo.getPwd());
		System.out.println("@NAME(VO)=>" + vo.getUname());
		System.out.println("-----------------");
		vo.setRdate("2023-01-03");
		// model.addAttribute("vo", vo); => @ModelAttribute(value = "vo")로 대신함
		// @ModelAttribute 사용하면 모델이 수행 후 값을 전송하는 것과 같다.
		return "member/success";
	}

}
