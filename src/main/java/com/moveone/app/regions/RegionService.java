package com.moveone.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DAO의 전처리, 후처리
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	
	public List<RegionDTO> getList() throws Exception {
		List<RegionDTO> list = regionDAO.getList();
		
		return list;
	}
	
}
