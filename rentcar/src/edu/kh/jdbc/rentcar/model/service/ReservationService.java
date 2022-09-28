package edu.kh.jdbc.rentcar.model.service;

import static edu.kh.jdbc.rentcar.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.locks.Condition;

import edu.kh.jdbc.rentcar.model.dao.ReservationDAO;
import edu.kh.jdbc.rentcar.model.vo.Reservation;
import edu.kh.jdbc.rentcar.model.vo.ReservationList;

public class ReservationService {
	
	private ReservationDAO dao = new ReservationDAO(); 

	public List<Reservation> domesticCar() throws Exception {
		
		Connection conn = getConnection();
		
		List<Reservation> reservationList = dao.domesticCar(conn);
		
		close(conn);

		return reservationList;
	}

	public List<Reservation> foreginCar() throws Exception {

		Connection conn = getConnection();
		
		List<Reservation> reservationList = dao.foreginCar(conn);
		
		close(conn);

		return reservationList;
	}

	public List<Reservation> motorcycle() throws Exception {

		Connection conn = getConnection();
		
		List<Reservation> reservationList = dao.motorcycle(conn);
		
		close(conn);

		return reservationList;
	}


	public int reserve(ReservationList reservationList) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.reserve(conn, reservationList);
		
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public ReservationList myReservation(int member2No) throws Exception {

		int result = 0;
		
		Connection conn = getConnection();
		
		ReservationList reservationList = dao.myReservation(conn, member2No);
		
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		
		return reservationList;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
