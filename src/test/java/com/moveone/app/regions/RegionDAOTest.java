package com.moveone.app.regions;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;
import com.moveone.app.util.Pager;

public class RegionDAOTest extends MyTest {

	@Autowired
	private RegionDAO regionDAO;
	
	//@Test
	public void getDetailTest() throws Exception {
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(9L);
		
		regionDTO = regionDAO.getDetail(regionDTO);
		
		assertNotNull(regionDTO);
	}

	//@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.setPage(1l);
		pager.makeRow();
		List<RegionDTO> list = regionDAO.getList(pager);
		
		assertEquals(10, list.size());
	}
	
	//@Test
	public void getTotalTest() throws Exception {
		Pager pager = new Pager();
		long total = regionDAO.getTotal(pager);
		
		long totalPage = (long) Math.ceil(100/10);
		
		assertEquals(12, totalPage);
	}
	
	//@Test
	public void addTest() throws Exception {
		RegionDTO regionDTO = new RegionDTO();
		
		for(int i = 0 ; i < 100 ; ++i) {
			regionDTO.setRegion_name("TEST" + i);
			
			int result = regionDAO.add(regionDTO);
			
			if(i%10 == 0) {
				Thread.sleep(500);
			}
		}
		
		System.out.println("100개 입력 완료");
		
		//assertNotEquals(0, result);
	}
	
	//@Test
	public void updateTest() throws Exception {
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(207L);
		regionDTO.setRegion_name("galaxy");
		
		int result = regionDAO.update(regionDTO);
		
		assertNotEquals(0, result);
	}
	
	//@Test
	public void deleteTest() throws Exception {
		RegionDTO dto = new RegionDTO();
		dto.setRegion_id(209L);
		
		int result = regionDAO.delete(dto);
		
		assertNotEquals(0, result);
	}
}
