package kr.co.kosmo.mvc.advice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

// @Aspect :advice
// @Component: 일반적인 bean으로 스캔당해서 등록됨
@Component
@Aspect
public class TodayAdvice {
	// 1. 공통 관심사항이 무엇인가 =>
	// 2. target ? => Today
	// 3. 시점을 생각해볼 필요가 있다.

	@Before("execution(* kr.co.kosmo.mvc.controller.TodayMy*.today*(..))")
	public void todayAdviceMethod() {
		String todate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("== Todate ==");
		System.out.println(todate);
	}

	@AfterReturning(pointcut = "execution(* kr.co.kosmo.mvc.controller.Today*.today*(..))", returning = "mav")
	public ModelAndView afterToday(JoinPoint jp, ModelAndView mav) {
		//RequestContexHolder사용해서 HttpServletRequest 받아서 사용자의 아이피를 받아서 로깅해보기
		ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = ra.getRequest();
		mav.addObject("reip",request.getRemoteAddr());
		System.out.println("reip=>"+request.getRemoteAddr());
		mav.addObject("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return mav;
	}
}
