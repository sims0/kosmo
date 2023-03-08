package kr.co.kosmo.mvc.vo;

public class SawonVO {
//	SABUN  NOT NULL NUMBER(10)   
//	SANAME          VARCHAR2(15) 
//	DEPTNO          NUMBER(10)   
//	SAJOB           VARCHAR2(20) 
//	SAPAY           NUMBER(10)   
//	SAHIRE          DATE         
//	GENDER          VARCHAR2(8)  
//	SAMGR           NUMBER(10)  

	private int sabun, deptno, sapay, samgr;
	private String saname, sajob, sahire, gender;
	private SawonPhoneVO sphone;

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getSapay() {
		return sapay;
	}

	public void setSapay(int sapay) {
		this.sapay = sapay;
	}

	public int getSamgr() {
		return samgr;
	}

	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}

	public String getSaname() {
		return saname;
	}

	public void setSaname(String saname) {
		this.saname = saname;
	}

	public String getSajob() {
		return sajob;
	}

	public void setSajob(String sajob) {
		this.sajob = sajob;
	}

	public String getSahire() {
		return sahire;
	}

	public void setSahire(String sahire) {
		this.sahire = sahire;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public SawonPhoneVO getSphone() {
		return sphone;
	}

	public void setSphone(SawonPhoneVO sphone) {
		this.sphone = sphone;
	}

}
