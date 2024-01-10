package com.moveone.app.regions;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.util.Pager;

//DAO의 전처리, 후처리
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	
	@Autowired
	//내장 객체 중에서 application
	private ServletContext servletContext;
	
	public List<RegionDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
	 	Long totalCount = regionDAO.getTotal(pager);
	 	if(totalCount == null) {
	 		totalCount = 0L;
	 	}
		pager.makeNum(totalCount);
		
		List<RegionDTO> list = regionDAO.getList(pager);
		return list;
	}
	
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
		return regionDAO.getDetail(regionDTO);
	}
	
	public int add(RegionDTO regionDTO, MultipartFile file) throws Exception {
		int result = regionDAO.add(regionDTO);
		
		System.out.println("result : " + result);
		
		// 1. 어디에 저장?
		String path = servletContext.getRealPath("/resources/upload");
		System.out.println(path);
		
		File f = new File(path, "regions");
		
		if(!f.exists()) {
			f.mkdirs();
		}
		// 2. 어떤 파일 명으로 저장
		// a. 시간 사용
		Calendar ca = Calendar.getInstance();
		String filename = ca.getTimeInMillis() + "_" + file.getOriginalFilename();
		
		// b. UUID 사용(universal unique identity)
		filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		System.out.println(filename);
		
		// 3. 파일을 저장
		// a. FileCopyUtils 클래스 사용
		f = new File(f,filename);
		FileCopyUtils.copy(file.getBytes(), f);
		
		// 4. DB에 정보를 저장
		RegionFileDTO fileDTO = new RegionFileDTO();
		fileDTO.setRegion_id(regionDTO.getRegion_id());
		fileDTO.setFileName(filename);
		fileDTO.setOriName(file.getOriginalFilename());
		
		result += 2*regionDAO.addFile(fileDTO);
		
		System.out.println("result2 : " + result);
		
		return result;
	}
	
	public int update(RegionDTO regionDTO) throws Exception {
		return regionDAO.update(regionDTO);
	}
	
	public int delete(RegionDTO regionDTO) throws Exception {
		return regionDAO.delete(regionDTO);
	}
}
