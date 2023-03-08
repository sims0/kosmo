package kr.co.kosmo.mvc.vo;

public class MemberDTO {
	/*
	 * NUM NUMBER(10,0) ID VARCHAR2(15 BYTE) PWD NUMBER(10,0) NAME VARCHAR2(34 BYTE)
	 * AGE NUMBER(5,0) GENDER VARCHAR2(6 BYTE) MDATE DATE
	 */

	private int num, age;
	private String id, name, gender, pwd, mdate;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

}
