package kr.co.kosmo.mvc.vo;

import java.util.List;

public class SurveyVO {
//	NUM   NOT NULL NUMBER        
//	SUB            VARCHAR2(100) 
//	CODE           NUMBER        
//	SDATE          DATE
	private String sub, sdate;
	private int num, code;
	
	private int subveytotal;

	public int getSubveytotal() {
		return subveytotal;
	}

	public void setSubveytotal(int subveytotal) {
		this.subveytotal = subveytotal;
	}

	private List<SurveyContentVO> subvey;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public List<SurveyContentVO> getSubvey() {
		return subvey;
	}

	public void setSubvey(List<SurveyContentVO> subvey) {
		this.subvey = subvey;
	}
}
