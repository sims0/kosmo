package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

//<context:component-scan base-package="kr.co.kosmo.mvc" />
//@Component 
//@Controller
//@Repository 
//@Service
//비즈니스 로직을 담당할 수 있다.

@Service
public class SurveyService {
//Dao를 단위처리 하기 위한 서비스
	@Autowired
	public SurveyDao surveyDao;
	// 모델에서 받아온 각 ㅏ데이터를 Dao에 각각 전달해서 단위처리를 하기 위한 메서드

	// @Transaction처리를 하기 위해서
	// 공통빈에서 설정 <tx:annotation-driven>, DataSourceTransactionManager di
	@Transactional
	public void addSurvey(SurveyVO vo, List<SurveyContentVO> list) {
		// 단위처리 적용!
		surveyDao.addSurvey(vo); // commmit X
		surveyDao.addSurveyContent(list);// commmit X
		// commit
	}

	public SurveyVO adminDetail(int num) {
		return surveyDao.adminDetail(num);
	}

	public void updateSurveyCnt(SurveyContentVO scvo) {
		surveyDao.updateSurveyCnt(scvo);
	}

	//리스트
	public List<SurveyVO> listSurvey() {
		return surveyDao.listSurvey();
	}

}
