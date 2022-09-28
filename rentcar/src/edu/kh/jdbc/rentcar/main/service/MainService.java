package edu.kh.jdbc.rentcar.main.service;

import static edu.kh.jdbc.rentcar.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.rentcar.main.dao.MainDAO;
import edu.kh.jdbc.rentcar.member2.vo.Member2;

public class MainService {
	
	private MainDAO dao = new MainDAO();

	public Member2 login(String member2Id, String member2Pw) throws Exception {

		Connection conn = getConnection();
		
		Member2 loginMember2 = dao.login(conn, member2Id, member2Pw);
		
		close(conn);
		
		return loginMember2;
	}

	public int idDupCheck(String member2Id) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.idDupCheck(conn, member2Id);
		
		close(conn);		
		
		return result;
	}

	public int signUp(Member2 member2) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member2);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);

		return result;
	}

}
