package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodayDefaultController {
	
	//Aop가 적용되어서 /main/index.jsp에서 ${today} 사용가능!
	@RequestMapping(value = {"/","/main"})
	public ModelAndView todayView(Model model) {
		ModelAndView mav = new ModelAndView("main/index");
		return mav;
		
	}
}
