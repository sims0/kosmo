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
//����Ͻ� ������ ����� �� �ִ�.

@Service
public class SurveyService {
//Dao�� ����ó�� �ϱ� ���� ����
	@Autowired
	public SurveyDao surveyDao;
	// �𵨿��� �޾ƿ� �� �������͸� Dao�� ���� �����ؼ� ����ó���� �ϱ� ���� �޼���

	// @Transactionó���� �ϱ� ���ؼ�
	// ����󿡼� ���� <tx:annotation-driven>, DataSourceTransactionManager di
	@Transactional
	public void addSurvey(SurveyVO vo, List<SurveyContentVO> list) {
		// ����ó�� ����!
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

	//����Ʈ
	public List<SurveyVO> listSurvey() {
		return surveyDao.listSurvey();
	}

}
