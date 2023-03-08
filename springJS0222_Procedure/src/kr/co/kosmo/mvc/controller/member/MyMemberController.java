package kr.co.kosmo.mvc.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

@Controller
@RequestMapping("/member") // 대분류
public class MyMemberController {

	@Autowired
	private MemberDaoInter memberDaoInter;

	@GetMapping(value = "/memberForm") // 중분류
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView("mymember/memberForm");
		return mav;
	}

	// 반환형이 String일 경우에는 viewName전달, Model인자로 보낼 수 있다.
	@PostMapping(value = "/memberIn")
	public String memberIn(MemberDTO dto) {
		System.out.println("id = " + dto.getId());
		System.out.println("pwd = " + dto.getPwd());
		System.out.println("Name = " + dto.getName());
		System.out.println("Gender = " + dto.getGender());
		System.out.println("Age = " + dto.getAge());
		// 회원가입이 끝나고 나면 이동할 페이지 설정 - redirect
		memberDaoInter.addMember(dto);
		return "redirect:/web/main";
	}

	@GetMapping(value = "/mypage")
	public ModelAndView myPage(String id) {
		ModelAndView mav = new ModelAndView("mymember/mypage");
		MemberDTO vo = memberDaoInter.myPage(id);
		mav.addObject("vo", vo);
		return mav;
	}

	@GetMapping(value = "/memberupform")
	public ModelAndView updateForm(String id) {
		ModelAndView mav = new ModelAndView("mymember/upmyForm");
		MemberDTO vo = memberDaoInter.myPage(id);
		mav.addObject("vo", vo);
		return mav;
	}

	@PostMapping(value = "/memberup")
	public String upMypage(MemberDTO vo) {
		memberDaoInter.updateMyPage(vo);
		return "redirect:/web/main";
	}

}
