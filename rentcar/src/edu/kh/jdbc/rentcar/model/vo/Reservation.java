package edu.kh.jdbc.rentcar.model.vo;

public class Reservation {
	
	private String reservationRcname;
	private int reservationAge;
	private String reservationPrice;
	private String reservationArea;
	private String reservationDate;

	
	public Reservation() {}

	public Reservation(String reservationRcname, int reservationAge, String reservationPrice, String reservationArea,
			String reservationDate) {
		super();
		this.reservationRcname = reservationRcname;
		this.reservationAge = reservationAge;
		this.reservationPrice = reservationPrice;
		this.reservationArea = reservationArea;
		this.reservationDate = reservationDate;

	}
	
	public String getReservationRcname() {
		return reservationRcname;
	}

	public void setReservationRcname(String reservationRcname) {
		this.reservationRcname = reservationRcname;
	}

	public int getReservationAge() {
		return reservationAge;
	}

	public void setReservationAge(int reservationAge) {
		this.reservationAge = reservationAge;
	}

	public String getReservationPrice() {
		return reservationPrice;
	}

	public void setReservationPrice(String reservationPrice) {
		this.reservationPrice = reservationPrice;
	}

	public String getReservationArea() {
		return reservationArea;
	}

	public void setReservationArea(String reservationArea) {
		this.reservationArea = reservationArea;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	
}
