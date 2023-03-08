package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Repository
public class SurveyDao {
	@Autowired
	private SqlSessionTemplate ss;

	public void addSurvey(SurveyVO vo) {
		ss.insert("survey.add", vo); //1번째 인서트
	}
	
	public void addSurveyContent(List<SurveyContentVO> list) {
		ss.insert("survey.addcontent", list); //다중인서트
	}
	
	public SurveyVO adminDetail(int num) {
		SurveyVO vo = ss.selectOne("survey.adminDetail", num);
		List<SurveyContentVO> list = vo.getSubvey();
		System.out.println("SurveyContentVO size: "+list.size());
		return vo;
	}
	
	public void updateSurveyCnt(SurveyContentVO scvo) {
		ss.update("survey.updateSurveyCnt", scvo);
	}
	
	//list구현
	public List<SurveyVO> listSurvey(){
		System.out.println("done@");
		return ss.selectList("survey.listSurvey");
	}
}
