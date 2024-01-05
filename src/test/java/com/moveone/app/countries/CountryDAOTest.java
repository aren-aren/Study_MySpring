package com.moveone.app.countries;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;

public class CountryDAOTest extends MyTest {

	@Autowired
	CountryDAO dao;
	
	@Test
	public void getListTest() throws Exception {
		List<CountryDTO> list = dao.getList();
		
		assertNotEquals(0, list.size());
	}

}
