package com.moveone.app.regions;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;

public class RegionDAOTest extends MyTest {

	@Autowired
	private RegionDAO regionDAO;
	
	@Test
	public void getDetailTest() throws Exception {
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(9);
		
		regionDTO = regionDAO.getDetail(regionDTO);
		
		assertNotNull(regionDTO);
	}

}
