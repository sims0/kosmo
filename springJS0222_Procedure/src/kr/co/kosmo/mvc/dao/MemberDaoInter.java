package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

public interface MemberDaoInter {

	public void addMember(MemberDTO dto);

	public int idcheck(String id);

	// ���̵�� ����� vo�� �����ϰ� ��ȯ������ id, name ���� ��ȯ
	public MemberDTO loginCheck(MemberDTO vo);

	// Aop���� ���� login�α� ó���� ���� �޼���
	public void addLoginLogging(MyLoginLoggerDTO vo);

	public MemberDTO myPage(String id);

	public MemberDTO updateMyPage(MemberDTO vo);
	
	//json
	public MemberDTO jsonDemo(String id); 
	
	//json list ����
	public List<MemberDTO> jsonDemolist();
	
	//json ���� ����¡
	public List<MemberDTO> jsonPagelist(Map<String, Integer> map);
	public int jsonCnt(); 
}
