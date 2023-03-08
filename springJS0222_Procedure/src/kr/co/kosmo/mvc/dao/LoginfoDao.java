package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;


@Repository
public class LoginfoDao implements LoginfoDaoInter {
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public List<MyLoginLoggerDTO> loginInfo(String idn) {
		return ss.selectList("member.log_info", idn);
	}
}
