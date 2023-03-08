package kr.co.kosmo.mvc.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

@Component
@Aspect
public class LoginAdvice {
	private String userAgent;

	@Autowired
	private MemberDaoInter memberList;

	@Around("execution(* kr.co.kosmo.mvc.controller.login.LoginCheckController.loginf*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		System.out.println("loginLogger 동작1");
		ModelAndView rpath = null;
		// step1) 메서드의 이름을 가져와서 로그인과 로그아웃을 구별한다.
		String methodName = jp.getSignature().getName();
		System.out.println("methodName: " + methodName); // 메서드 이름 확인
		// 가져와야 하는 정보
		// step2) Joinpoint로부터 타겟 객체의 메서드의 인자값 받아오기
		Object[] fd = jp.getArgs();
//			for(Object e:fd) {
//				System.out.println(e.getClass().getName());
//			}
		if (methodName.equals("loginfProcess")) {
			// getArgs: 세션, request,userAgent, DTO -4개
			
			try {
				rpath = (ModelAndView) jp.proceed();//로그인 메서드 호출
			} catch (Throwable e) {
				e.printStackTrace();
			}
			
			HttpSession session = (HttpSession) fd[0];
			userAgent = (String) fd[3];
			String uid=(String) session.getAttribute("sessionID");
			String reip = ((HttpServletRequest)(fd[1])).getRemoteAddr();
			System.out.println("agent=> " + userAgent);
			System.out.println("reIP=> "+reip);
			System.out.println("uid=> "+uid);
			//로그인 정보를 데이터베이스에 저장하기
			MyLoginLoggerDTO vo = new MyLoginLoggerDTO();
			vo.setIdn(uid);
			vo.setStatus("login");
			vo.setReip(reip);
			vo.setUagent(userAgent);
			memberList.addLoginLogging(vo);
			
		} else if (methodName.equals("loginfoutProcess")) {
			// getArgs: 세션,request -2개
			HttpSession session = (HttpSession) fd[0];
			String uid=(String) session.getAttribute("sessionID");
			String reip = ((HttpServletRequest)(fd[1])).getRemoteAddr();
			//로그아웃 정보를 데이터베이스에 저장하기
			MyLoginLoggerDTO vo = new MyLoginLoggerDTO();
			vo.setIdn(uid);
			vo.setStatus("logout");
			vo.setReip(reip);
			vo.setUagent(userAgent);
			memberList.addLoginLogging(vo);
			try {
				rpath = (ModelAndView) jp.proceed(); //로그아웃 메서드 호출
				
				
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		/*
		try {
			rpath = (ModelAndView) jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		*/
		System.out.println("loginLogger 동작2");
		System.out.println("----------------------");
		return rpath;
	}
}
