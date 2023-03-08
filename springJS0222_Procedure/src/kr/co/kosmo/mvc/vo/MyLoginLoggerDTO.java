package kr.co.kosmo.mvc.vo;

public class MyLoginLoggerDTO {
//	NUM    NOT NULL NUMBER        
//	IDN             VARCHAR2(10)  
//	REIP            VARCHAR2(30)  
//	UAGENT          VARCHAR2(150) 
//	STATUS          VARCHAR2(10)  	로그인 상태
//	SSTIME          DATE  			로그인 시간대
	private int num, cnt;
	private String idn, reip, uagent, status, sstime, eetime;

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getIdn() {
		return idn;
	}

	public void setIdn(String idn) {
		this.idn = idn;
	}

	public String getReip() {
		return reip;
	}

	public void setReip(String reip) {
		this.reip = reip;
	}

	public String getUagent() {
		return uagent;
	}

	public void setUagent(String uagent) {
		this.uagent = uagent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSstime() {
		return sstime;
	}

	public void setSstime(String sstime) {
		this.sstime = sstime;
	}

	public String getEetime() {
		return eetime;
	}

	public void setEetime(String eetime) {
		this.eetime = eetime;
	}

}
