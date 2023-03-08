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
	 {"sub":"차트문제","sdate":"2023-01-18 14:38:01","num":21,"code":0,"subveytotal":0,"subvey":
	 [{"subtype":"A    ","surveytitle":"비가옴","subcode":21,"surveycnt":500},
	 {"subtype":"B    ","surveytitle":"안옴","subcode":21,"surveycnt":200},
	 {"subtype":"C    ","surveytitle":"모름","subcode":21,"surveycnt":666},
	 {"subtype":"D    ","surveytitle":"태풍","subcode":21,"surveycnt":55},
	 {"subtype":"E    ","surveytitle":"관심없음","subcode":21,"surveycnt":120}]}
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
			//비가옵니다.:500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		//{"안옴":200,"비가옴":500,"관심없음":120,"모름":666,"태풍":55}
		return map;
	}
	
	//Map으로 전환한 json데이터와 title을 함께 보내기
	//{"안옴":200,"비가옴":500,"관심없음":120,"모름":666,"태풍":55}
	//map/vo => {"sub":"내일 비와?","안옴":200,"비가옴":500,"관심없음":120,"모름":666,"태풍":55}
	//String=> [{"sub":"내일 비와?"},{}]
	//String=> ["내일 비와?":{~~~~}
	
	@RequestMapping(value = "/surveyJsonObj2", produces = "application/json;charset=utf-8")
	public String surveyDetailJTitle(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		String subject = vo.getSub();
		System.out.println(subject);
		Map<String, Integer> map = new HashedMap();
		
		for (SurveyContentVO e : vo.getSubvey()) {
			//비가옵니다.:500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		//json결과를 문자열로 반환
		String res = null;
		//ObjectMapper 객체를 가지고 반환할 수 있다.
		ObjectMapper mapper = new ObjectMapper();
		try {
			//{"안옴":200,"비가옴...
			res = mapper.writeValueAsString(map);
			//[{"sub":"내일 비와?"},map]
			res = "[{\"sub\":\""+vo.getSub()+"\"},"+res+"]";
			
			//String=> ["내일 비와?":map]
			//res = "[\""+vo.getSub()+"\""+":"+res+"]";
			System.out.println(res);
			
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return res;
	}
	
	
}
