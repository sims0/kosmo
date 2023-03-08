package kr.co.kosmo.mvc.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;

public interface SawonDaoInter {

	// deptlist => getDeptList
	public DeptVO getDeptList(int deptno);
	
	// sawonphone = getSawonPhoneList
	public List<SawonVO> getSawonPhoneList();
	
	// 프로시저 값 넣기
	public void procedureAdd(SawonVO vo);
	// 프로시저 리스트 출력
	public List<HashMap> procedureList(int num);
}
