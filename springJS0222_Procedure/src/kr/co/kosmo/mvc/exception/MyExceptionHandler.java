package kr.co.kosmo.mvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;

@ControllerAdvice
public class MyExceptionHandler {

	// 모든 예외
	@ExceptionHandler(Exception.class)
	public String myHandlerException(Model m, Exception e) {
		e.printStackTrace();
		System.out.println("예외 메세지:" + e.getMessage());
		String viewName = "";
		// 파라미터가 없을 때 @RequestParam 체크되어서
		// Required String parameter 'id' is not present
		if (e instanceof MissingServletRequestParameterException) {
			m.addAttribute("emsg", "파라미터값을 올바르게 작성하시오.1");
			viewName = "error/paramExeption";
		} else if (e instanceof UnsatisfiedServletRequestParameterException) {
			m.addAttribute("emsg", "파라미터값을 올바르게 작성하시오.2");
			viewName = "error/paramExeption";
		} else {
			m.addAttribute("emsg", "예외가 발생함?");
			viewName = "error/paramExeption";
		}
		return viewName;
	}
}
