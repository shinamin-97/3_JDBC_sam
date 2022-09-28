package edu.kh.jdbc.rentcar.model.vo;

public class RentCar {
	
	private int rentCarNo;			// 차량 번호
	private String rentCarTitle;	// 차량 분류
	private String rentCarName;		// 차량 이름
	private String fuel;			// 차량 연비
	private int model;				// 차량 연식
	private int seatNumber;			// 차량 좌석 수
	
	public RentCar() { }

	public RentCar(int rentCarNo, String rentCarTitle, String rentCarName, String fuel, int model, int seatNumber) {
		super();
		this.rentCarNo = rentCarNo;
		this.rentCarTitle = rentCarTitle;
		this.rentCarName = rentCarName;
		this.fuel = fuel;
		this.model = model;
		this.seatNumber = seatNumber;
	}

	public int getRentCarNo() {
		return rentCarNo;
	}

	public void setRentCarNo(int rentCarNo) {
		this.rentCarNo = rentCarNo;
	}

	public String getRentCarTitle() {
		return rentCarTitle;
	}

	public void setRentCarTitle(String rentCarTitle) {
		this.rentCarTitle = rentCarTitle;
	}

	public String getRentCarName() {
		return rentCarName;
	}

	public void setRentCarName(String rentCarName) {
		this.rentCarName = rentCarName;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
	

}
