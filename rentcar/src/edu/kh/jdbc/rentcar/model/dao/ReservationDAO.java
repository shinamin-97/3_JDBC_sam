package edu.kh.jdbc.rentcar.model.dao;

import static edu.kh.jdbc.rentcar.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.rentcar.model.vo.Reservation;
import edu.kh.jdbc.rentcar.model.vo.ReservationList;

public class ReservationDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ReservationDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("reservation-query.xml"));
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public List<Reservation> domesticCar(Connection conn) throws Exception {

		List<Reservation> reservationList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("domesticCar");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Reservation reservation = new Reservation();
				
				reservation.setReservationRcname(rs.getString("RESERVATION_RCNAME"));
				reservation.setReservationAge(rs.getInt("RESERVATION_AGE"));				
				reservation.setReservationPrice(rs.getString("RESERVATION_PRICE"));
				reservation.setReservationArea(rs.getString("RESERVATION_AREA"));
				reservation.setReservationDate(rs.getString("RESERVATION_DATE"));

				reservationList.add(reservation);
				
			}
			
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;
	}

	public List<Reservation> foreginCar(Connection conn) throws Exception {

		List<Reservation> reservationList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("foreginCar");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Reservation reservation = new Reservation();
				
				reservation.setReservationRcname(rs.getString("RESERVATION_RCNAME"));
				reservation.setReservationAge(rs.getInt("RESERVATION_AGE"));				
				reservation.setReservationPrice(rs.getString("RESERVATION_PRICE"));
				reservation.setReservationArea(rs.getString("RESERVATION_AREA"));
				reservation.setReservationDate(rs.getString("RESERVATION_DATE"));

				reservationList.add(reservation);
				
			}
			
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;
	}

	public List<Reservation> motorcycle(Connection conn) throws Exception {

		List<Reservation> reservationList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("motorcycle");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Reservation reservation = new Reservation();
				
				reservation.setReservationRcname(rs.getString("RESERVATION_RCNAME"));
				reservation.setReservationAge(rs.getInt("RESERVATION_AGE"));				
				reservation.setReservationPrice(rs.getString("RESERVATION_PRICE"));
				reservation.setReservationArea(rs.getString("RESERVATION_AREA"));
				reservation.setReservationDate(rs.getString("RESERVATION_DATE"));

				reservationList.add(reservation);
				
			}
			
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return reservationList;
	}


	

	public int reserve(Connection conn, ReservationList reservationList) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("reserve");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reservationList.getReservationListRcname());
			pstmt.setString(2, reservationList.getMember2Nm());
			pstmt.setString(3, reservationList.getInsurance());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ReservationList myReservation(Connection conn, int member2No) throws Exception{

		ReservationList reservationList = null; 
		
		try {
			
			String sql = prop.getProperty("myReservation");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, member2No);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				reservationList = new ReservationList();
				
				reservationList.setMember2No(rs.getInt("MEMBER2_NO"));
				reservationList.setReservationListNo(rs.getInt("RESERVATIONLIST_NO"));
				reservationList.setReservationListRcname(rs.getString("RESERVATION_RCNAME"));
				reservationList.setMember2Nm(rs.getString("MEMBER2_NM"));
				reservationList.setInsurance(rs.getString("INSREANCE"));
				reservationList.setReservationDt(rs.getString("RESERVATION_DT"));
				
				
				
				
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
			
		}
		
		return reservationList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
