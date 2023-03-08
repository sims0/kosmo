package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

public interface LoginfoDaoInter {
	public List<MyLoginLoggerDTO> loginInfo(String idn);
}
