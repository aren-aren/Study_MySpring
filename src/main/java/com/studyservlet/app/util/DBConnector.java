package com.studyservlet.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	// 1. IP:PORT
	// 2. ID, PW
	
	public static Connection getConnector() throws Exception {
		String user = "moveone";
		String password = "user01";
		String url = "jdbc:oracle:thin:@13.209.7.122:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		// 1. 드라이버를 메모리에 로딩(객체를 생성)
		Class.forName(driver);
		// 2. DB연결
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con) throws Exception {
		rs.close();
		st.close();
		con.close();
	}
	
	public static void disConnect(PreparedStatement st, Connection con) throws Exception {
		st.close();
		con.close();
	}
}
