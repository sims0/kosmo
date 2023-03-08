package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodayMyProfileController {
	//value = "/myprofile" 중복되면 안됨 (cf.id)
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public ModelAndView todayProfile() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("profile", "나는 스프링의 김길동이다.");
		mav.setViewName("today/todayProfile"); //forward로 보냄
		return mav;
	}

	@RequestMapping(value = "todaywk", method = RequestMethod.GET)
	public ModelAndView todayWork() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("work", "시간과 예산을 더 주신다면...");
		mav.setViewName("today/todayWork");
		return mav;
	}

}
