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

import com.moveone.app.util.FileManager;
import com.moveone.app.util.Pager;

//DAO의 전처리, 후처리
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	@Autowired
	//내장 객체 중에서 application
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
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
		/*
		 * pom.xml -> commons fileupload
		 * jsp form -> enctype="multipart/form-data"
		 * -context.xml -> MultipartResolver를 생성해주도록 Bean으로 등록
		 * controller -> MultipartFile로 file을 받음
		 * 
		 * 먼저 region을 insert후 region_id를 받아옴
		 * 파일의 경로, 파일 이름(중복을 피하기 위해 calendar 또는 UUID 사용)을 이용하여 File 생성
		 * FileCopyUtils을 사용하여 경로에 파일 저장
		 * FileDTO에 필요한 정보들과 region_id를 저장후 insert
		 * 
		 * 다수의 매개변수를 받을 경우 배열로 받음
		 *  -> String[] ch (name이 ch인 checkbox를 통해 매개변수를 입력받았다면 다수의 값이 올 수 있으니 배열로 받음)
		 */
		int result = regionDAO.add(regionDTO);
		
		System.out.println("result : " + result);
		
		// 1. 어디에 저장?
		String path = servletContext.getRealPath("/resources/upload/regions");
		System.out.println(path);
		
		String filename = fileManager.fileSave(path, file);
		
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
		//파일명 조회
		List<RegionFileDTO> fileList = regionDAO.getListFiles(regionDTO);
		
		//DB에서 삭제
		int result = regionDAO.delete(regionDTO);
		//Storage에서 삭제
		String path = servletContext.getRealPath("/resources/upload/regions");
		boolean isDeleted = true;
		for(RegionFileDTO f : fileList) {
			isDeleted &= fileManager.fileDelete(path, f.getFileName());
		}
		
		if(!isDeleted) {
			System.out.println("모두 삭제 실패");
		}
		
		return result;
	}
}
