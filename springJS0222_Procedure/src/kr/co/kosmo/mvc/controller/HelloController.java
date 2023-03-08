//package kr.co.kosmo.mvc;
package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//HelloControllerd 예전 모델에 해당
//DispatcherServlet란 컨트롤 서블릿이 스프링 컨테이너에 의해서 Model을 주입받아서 실행
//HandlerMapping이 요청사항을 분석해준다.
//스프링컨테이너를 가진 컨트롤러
@Controller // 생략X
public class HelloController {
	
	//http://localhost/spring0103_mvc/hello (request) : 중복되면 안됨!
	// ActionFactory-------->SpringContainer-------->DispatcherServlet
	// ----->HandlerMapping이 분석
	@RequestMapping(value = "/hello")
	public ModelAndView myHello() {
		ModelAndView mav = new ModelAndView();
		// request.setAttribute("key",Val);
		mav.addObject("msg", "<h1>안녕하세요2, 나의 첫번째 springMVC입니다.</h1>");
		// new ActionForward("Hello.jsp",false); 
		// 기본값이 forward. redirect는 다른식으로 설정 
		mav.setViewName("hello");
		return mav;
	}
}
