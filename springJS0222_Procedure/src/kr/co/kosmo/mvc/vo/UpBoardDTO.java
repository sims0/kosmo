package kr.co.kosmo.mvc.vo;

import org.springframework.web.multipart.MultipartFile;

public class UpBoardDTO {
//	NUM	NUMBER
//	SUB	VARCHAR2(100 BYTE)
//	WRITER	VARCHAR2(34 BYTE)
//	PWD	VARCHAR2(10 BYTE)
//	CONT	VARCHAR2(400 BYTE)
//	IMGN	VARCHAR2(50 BYTE)
//	UDATE	DATE

	private int num;
	private String sub, writer, pwd, cont, imgn, udate;
	//spring web 제공해주는 multipart.MultipartFile
	//image이름만 db에 저장
	private MultipartFile mfile;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public String getImgn() {
		return imgn;
	}

	public void setImgn(String imgn) {
		this.imgn = imgn;
	}

	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
	}

	public MultipartFile getMfile() {
		return mfile;
	}

	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}

}
