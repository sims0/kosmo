package kr.co.kosmo.mvc.advice;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.LoginfoDaoInter;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

@Component
@Aspect
public class LogInfoAdvice {

	@Autowired
	private LoginfoDaoInter loginfo;

	@Around("execution(* kr.co.kosmo.mvc.controller.member.MyMemberController.myPage(..))")
	private ModelAndView loglist(ProceedingJoinPoint jp) {
		System.out.println("start"); // 어드바이스 시작
		ModelAndView rpath = null;
		try {
			rpath = (ModelAndView) jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		Object[] fd = jp.getArgs(); // jp의 인자 가져오기
		String idn = (String) fd[0];
		List<MyLoginLoggerDTO> list = loginfo.loginInfo(idn);
		rpath.addObject("list", list);
		return rpath;
	}

}
