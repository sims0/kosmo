package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

// Dao단은 @Repository사용하는 순간 => Dao를 빈으로 등록시켜준다.
// 기본이 싱글톤
@Repository
public class MemberDao implements MemberDaoInter {

	// di주입
	// kosmo-web.xml에서 정의한 bean byName
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addMember(MemberDTO dto) {
		// SqlSession ss = FactoryService.getFactory().openSession(true); 대신해주는 설정이
		// <bean id="ss" class="org.mybatis.spring.SqlSessionTemplate">
		ss.insert("member.add", dto);
	}

	@Override
	public int idcheck(String id) {
		return ss.selectOne("member.idchk", id);
	}

	@Override
	public MemberDTO loginCheck(MemberDTO vo) {
		return ss.selectOne("member.login", vo);
	}

	@Override
	public void addLoginLogging(MyLoginLoggerDTO vo) {
		ss.insert("member.logger_in", vo);
	}

	@Override
	public MemberDTO myPage(String id) {
		return ss.selectOne("member.mypage", id);
	}

	@Override
	public MemberDTO updateMyPage(MemberDTO vo) {
		return ss.selectOne("member.update", vo);
	}

	@Override
	public MemberDTO jsonDemo(String id) {
		return ss.selectOne("member.jsonDemo", id);
	}

	@Override
	public List<MemberDTO> jsonDemolist() {
		return ss.selectList("member.jsonDemolist");
	}

	@Override
	public int jsonCnt() {
		return ss.selectOne("member.jsonCnt");
	}

	@Override
	public List<MemberDTO> jsonPagelist(Map<String, Integer> map) {
		return ss.selectList("member.jsonpagelist");
	}

	


}
