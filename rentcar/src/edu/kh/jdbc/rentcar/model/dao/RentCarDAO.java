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


import edu.kh.jdbc.rentcar.model.vo.RentCar;

public class RentCarDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public RentCarDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("rentcar-query.xml"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<RentCar> domesticCar(Connection conn) throws Exception {

		List<RentCar> rentCarList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("domesticCar");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				RentCar rentCar = new RentCar();
				
				rentCar.setRentCarNo(rs.getInt("RENTCAR_NO"));
				rentCar.setRentCarTitle(rs.getString("RENTCAR_TITLE"));
				rentCar.setRentCarName(rs.getString("RENTCAR_NM"));
				rentCar.setFuel(rs.getString("RENTCAR_FUEL"));
				rentCar.setModel(rs.getInt("RENTCAR_MODEL"));
				rentCar.setSeatNumber(rs.getInt("RENTCAR_SEATNUMBER"));
				
				rentCarList.add(rentCar);
				
			}
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return rentCarList;
	}

	public List<RentCar> foreginCar(Connection conn) throws Exception {
		List<RentCar> rentCarList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("foreginCar");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				RentCar rentCar = new RentCar();
				
				rentCar.setRentCarNo(rs.getInt("RENTCAR_NO"));
				rentCar.setRentCarTitle(rs.getString("RENTCAR_TITLE"));
				rentCar.setRentCarName(rs.getString("RENTCAR_NM"));
				rentCar.setFuel(rs.getString("RENTCAR_FUEL"));
				rentCar.setModel(rs.getInt("RENTCAR_MODEL"));
				rentCar.setSeatNumber(rs.getInt("RENTCAR_SEATNUMBER"));
				
				rentCarList.add(rentCar);
				
			}
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return rentCarList;

	}

	public List<RentCar> motorcycle(Connection conn) throws Exception {
		List<RentCar> rentCarList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("motorcycle");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				RentCar rentCar = new RentCar();
				
				rentCar.setRentCarNo(rs.getInt("RENTCAR_NO"));
				rentCar.setRentCarTitle(rs.getString("RENTCAR_TITLE"));
				rentCar.setRentCarName(rs.getString("RENTCAR_NM"));
				rentCar.setFuel(rs.getString("RENTCAR_FUEL"));
				rentCar.setModel(rs.getInt("RENTCAR_MODEL"));
				rentCar.setSeatNumber(rs.getInt("RENTCAR_SEATNUMBER"));
				
				rentCarList.add(rentCar);
				
			}
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return rentCarList;

	}

	public List<RentCar> searchRentCar(Connection conn, String rentCarName) throws Exception {

		List<RentCar> searchRentCar = new ArrayList<>();
		
		try {
		
		String sql = prop.getProperty("searchRentCar");

		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, rentCarName);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			RentCar rentCar = new RentCar();
			
			rentCar.setRentCarNo(rs.getInt("RENTCAR_NO"));
			rentCar.setRentCarTitle(rs.getString("RENTCAR_TITLE"));
			rentCar.setRentCarName(rs.getString("RENTCAR_NM"));
			rentCar.setFuel(rs.getString("RENTCAR_FUEL"));
			rentCar.setModel(rs.getInt("RENTCAR_MODEL"));
			rentCar.setSeatNumber(rs.getInt("RENTCAR_SEATNUMBER"));
			
			searchRentCar.add(rentCar);
		}
		
		
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return searchRentCar;
	
	
	
	
	}
	

	
	
}
