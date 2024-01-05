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
	
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
		return regionDAO.getDetail(regionDTO);
	}
	
	public int add(RegionDTO regionDTO) throws Exception {
		return regionDAO.add(regionDTO);
	}
	
	public int update(RegionDTO regionDTO) throws Exception {
		return regionDAO.update(regionDTO);
	}
	
	public int delete(RegionDTO regionDTO) throws Exception {
		return regionDAO.delete(regionDTO);
	}
}
