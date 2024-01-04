package com.moveone.app;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DBConnectTest extends MyTest {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void connectTest() throws Exception {
		Connection con = dataSource.getConnection();
		
		assertNotNull(con);
	}

}
