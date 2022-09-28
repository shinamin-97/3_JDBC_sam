package edu.kh.jdbc.rentcar.model.service;

import static edu.kh.jdbc.rentcar.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;


import edu.kh.jdbc.rentcar.model.dao.RentCarDAO;
import edu.kh.jdbc.rentcar.model.vo.RentCar;

public class RentCarService {
	
	private RentCarDAO dao = new RentCarDAO();
	
	public List<RentCar> domesticCar() throws Exception {
		
		Connection conn = getConnection();
		
		List<RentCar> rentCarList = dao.domesticCar(conn);
		
		close(conn);
		
		return rentCarList;

	}


	public List<RentCar> foreginCar() throws Exception {
		
		Connection conn = getConnection();
		
		List<RentCar> rentCarList = dao.foreginCar(conn);
		
		close(conn);
		
		return rentCarList;
	}


	public List<RentCar> motorcycle() throws Exception {

		Connection conn = getConnection();
		
		List<RentCar> rentCarList = dao.motorcycle(conn);
		
		close(conn);
		
		return rentCarList;
	}



	public List<RentCar> searchRentCar(String rentCarName) throws Exception {
		
		Connection conn = getConnection();
		
		List<RentCar> rentCarList = dao.searchRentCar(conn, rentCarName);
		
		close(conn);
		
		return rentCarList;
	}


}
