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
	
	// ���ν��� �� �ֱ�
	public void procedureAdd(SawonVO vo);
	// ���ν��� ����Ʈ ���
	public List<HashMap> procedureList(int num);
}
