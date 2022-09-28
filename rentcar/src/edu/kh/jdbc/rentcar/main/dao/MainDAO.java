package edu.kh.jdbc.rentcar.main.dao;

import static edu.kh.jdbc.rentcar.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.rentcar.main.view.MainView;
import edu.kh.jdbc.rentcar.member2.vo.Member2;

public class MainDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	
	public MainDAO() {
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream("main-query.xml"));
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
	public Member2 login(Connection conn, String member2Id, String member2Pw) throws Exception {

		Member2 loginMember2 = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member2Id);
			pstmt.setString(2, member2Pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginMember2 = new Member2();
				
				loginMember2.setMember2No(rs.getInt("MEMBER2_NO"));
				loginMember2.setMember2Id(member2Id);
				loginMember2.setMember2Name(rs.getString("MEMBER2_NM"));
				loginMember2.setMember2Gender(rs.getString("MEMBER2_GENDER"));
				loginMember2.setEnrollDate(rs.getString("ENROLL_DATE"));
				loginMember2.setLicense(rs.getString("LICENSE"));
				
				
				
			}
			
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		return loginMember2;
	}


	public int idDupCheck(Connection conn, String member2Id) throws Exception {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("idDupCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member2Id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				result = rs.getInt(1);

			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return result;
	}


	public int signUp(Connection conn, Member2 member2) throws Exception {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member2.getMember2Id());
			pstmt.setString(2, member2.getMember2Pw());
			pstmt.setString(3, member2.getMember2Name());
			pstmt.setString(4, member2.getMember2Gender());
			pstmt.setString(5, member2.getLicense());
			
			result = pstmt.executeUpdate();
			
			
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
		
	}


