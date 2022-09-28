package edu.kh.jdbc.rentcar.model.vo;

public class ReservationList {
	
	private int reservationListNo;
	private String reservationListRcname;
	private String member2Nm;
	private String insurance;
	private String reservationDt;
	private int member2No;
	
	public ReservationList() {}

	public ReservationList(int reservationListNo, String reservationListRcname, String member2Nm, String insurance,
			String reservationDt) {
		super();
		this.reservationListNo = reservationListNo;
		this.reservationListRcname = reservationListRcname;
		this.member2Nm = member2Nm;
		this.insurance = insurance;
		this.reservationDt = reservationDt;
	}

	public ReservationList(int member2No) {
		super();
		this.member2No = member2No;
	}

	public int getReservationListNo() {
		return reservationListNo;
	}

	public void setReservationListNo(int reservationListNo) {
		this.reservationListNo = reservationListNo;
	}

	public String getReservationListRcname() {
		return reservationListRcname;
	}

	public void setReservationListRcname(String reservationListRcname) {
		this.reservationListRcname = reservationListRcname;
	}

	public String getMember2Nm() {
		return member2Nm;
	}

	public void setMember2Nm(String member2Nm) {
		this.member2Nm = member2Nm;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getReservationDt() {
		return reservationDt;
	}

	public void setReservationDt(String reservationDt) {
		this.reservationDt = reservationDt;
	}

	public int getMember2No() {
		return member2No;
	}

	public void setMember2No(int member2No) {
		this.member2No = member2No;
	}

	
	

}
