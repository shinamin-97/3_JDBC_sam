package edu.kh.jdbc.rentcar.member2.vo;

public class Member2 {
	
	private int member2No;
	private String member2Id;
	private String member2Pw;
	private String member2Name;
	private String member2Gender;
	private String enrollDate;
	private String license;
	private String secessionFlag;
	
	public Member2() { }
	
	public Member2(String member2Id, String member2Pw, String member2Name, String member2Gender, String license) {
		super();
		this.member2No = member2No;
		this.member2Id = member2Id;
		this.member2Pw = member2Pw;
		this.member2Name = member2Name;
		this.member2Gender = member2Gender;
		this.enrollDate = enrollDate;
		this.license = license;
		this.secessionFlag = secessionFlag;
	}

	public int getMember2No() {
		return member2No;
	}

	public void setMember2No(int member2No) {
		this.member2No = member2No;
	}

	public String getMember2Id() {
		return member2Id;
	}

	public void setMember2Id(String member2Id) {
		this.member2Id = member2Id;
	}

	public String getMember2Pw() {
		return member2Pw;
	}

	public void setMember2Pw(String member2Pw) {
		this.member2Pw = member2Pw;
	}

	public String getMember2Name() {
		return member2Name;
	}

	public void setMember2Name(String member2Name) {
		this.member2Name = member2Name;
	}

	public String getMember2Gender() {
		return member2Gender;
	}

	public void setMember2Gender(String member2Gender) {
		this.member2Gender = member2Gender;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getSecessionFlag() {
		return secessionFlag;
	}

	public void setSecessionFlag(String secessionFlag) {
		this.secessionFlag = secessionFlag;
	}

	
	
}
