package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

public interface MemberDaoInter {

	public void addMember(MemberDTO dto);

	public int idcheck(String id);

	// 아이디와 비번을 vo로 전송하고 반환값으로 id, name 등을 반환
	public MemberDTO loginCheck(MemberDTO vo);

	// Aop에서 사용될 login로깅 처리를 위한 메서드
	public void addLoginLogging(MyLoginLoggerDTO vo);

	public MemberDTO myPage(String id);

	public MemberDTO updateMyPage(MemberDTO vo);
	
	//json
	public MemberDTO jsonDemo(String id); 
	
	//json list 과제
	public List<MemberDTO> jsonDemolist();
	
	//json 과제 페이징
	public List<MemberDTO> jsonPagelist(Map<String, Integer> map);
	public int jsonCnt(); 
}
