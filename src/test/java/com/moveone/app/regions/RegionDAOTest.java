package com.moveone.app.regions;

import static org.junit.Assert.*;

import java.util.List;

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

	@Test
	public void getListTest() throws Exception {
		List<RegionDTO> list = regionDAO.getList();
		
		assertNotEquals(0, list.size());
	}
	
	//@Test
	public void addTest() throws Exception {
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_name("TEST");
		
		int result = regionDAO.add(regionDTO);
		
		assertNotEquals(0, result);
	}
	
	//@Test
	public void updateTest() throws Exception {
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(207);
		regionDTO.setRegion_name("galaxy");
		
		int result = regionDAO.update(regionDTO);
		
		assertNotEquals(0, result);
	}
	
	//@Test
	public void deleteTest() throws Exception {
		RegionDTO dto = new RegionDTO();
		dto.setRegion_id(209);
		
		int result = regionDAO.delete(dto);
		
		assertNotEquals(0, result);
	}
}
