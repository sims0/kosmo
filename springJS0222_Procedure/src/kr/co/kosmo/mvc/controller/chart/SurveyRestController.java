package kr.co.kosmo.mvc.controller.chart;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@RestController
public class SurveyRestController {

	@Autowired
	private SurveyService surveyService;
	
	/*
	 {"sub":"��Ʈ����","sdate":"2023-01-18 14:38:01","num":21,"code":0,"subveytotal":0,"subvey":
	 [{"subtype":"A    ","surveytitle":"�񰡿�","subcode":21,"surveycnt":500},
	 {"subtype":"B    ","surveytitle":"�ȿ�","subcode":21,"surveycnt":200},
	 {"subtype":"C    ","surveytitle":"��","subcode":21,"surveycnt":666},
	 {"subtype":"D    ","surveytitle":"��ǳ","subcode":21,"surveycnt":55},
	 {"subtype":"E    ","surveytitle":"���ɾ���","subcode":21,"surveycnt":120}]}
	 */
	@RequestMapping(value = "/surveyJsonObjDemo1")
	public SurveyVO surveyDetail(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		return vo;
	}
	
	@RequestMapping(value = "/surveyJsonObj", produces = "application/json;charset=utf-8")
	public Map<String, Integer> surveyDetailJson(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		//key,Val=>Map
		Map<String, Integer> map = new HashedMap();
		for (SurveyContentVO e : vo.getSubvey()) {
			//�񰡿ɴϴ�.:500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		//{"�ȿ�":200,"�񰡿�":500,"���ɾ���":120,"��":666,"��ǳ":55}
		return map;
	}
	
	//Map���� ��ȯ�� json�����Ϳ� title�� �Բ� ������
	//{"�ȿ�":200,"�񰡿�":500,"���ɾ���":120,"��":666,"��ǳ":55}
	//map/vo => {"sub":"���� ���?","�ȿ�":200,"�񰡿�":500,"���ɾ���":120,"��":666,"��ǳ":55}
	//String=> [{"sub":"���� ���?"},{}]
	//String=> ["���� ���?":{~~~~}
	
	@RequestMapping(value = "/surveyJsonObj2", produces = "application/json;charset=utf-8")
	public String surveyDetailJTitle(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		String subject = vo.getSub();
		System.out.println(subject);
		Map<String, Integer> map = new HashedMap();
		
		for (SurveyContentVO e : vo.getSubvey()) {
			//�񰡿ɴϴ�.:500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		//json����� ���ڿ��� ��ȯ
		String res = null;
		//ObjectMapper ��ü�� ������ ��ȯ�� �� �ִ�.
		ObjectMapper mapper = new ObjectMapper();
		try {
			//{"�ȿ�":200,"�񰡿�...
			res = mapper.writeValueAsString(map);
			//[{"sub":"���� ���?"},map]
			res = "[{\"sub\":\""+vo.getSub()+"\"},"+res+"]";
			
			//String=> ["���� ���?":map]
			//res = "[\""+vo.getSub()+"\""+":"+res+"]";
			System.out.println(res);
			
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return res;
	}
	
	
}
