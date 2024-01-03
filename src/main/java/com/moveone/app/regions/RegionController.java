package com.moveone.app.regions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/regions/*")
public class RegionController {
	private RegionDAO dao;
	
	public RegionController() {
		this.dao = new RegionDAO();
	}
	
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(HttpServletRequest request) throws Exception {
		String id = request.getParameter("region_id");
		String name = request.getParameter("region_name");
		
		RegionDTO dto = new RegionDTO();
		dto.setRegion_id(Integer.valueOf(id));
		dto.setRegion_name(name);
		
		int result = dao.add(dto);
		
		String msg = "등록 실패";
		if(result > 0) {
			//성공
			msg = "등록성공";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("path", "./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "regions/add";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		System.out.println(request);
		System.out.println("Regions List");
		
		List<RegionDTO> list = dao.getList();
		
		request.setAttribute("list", list);
		
		return "regions/list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(HttpServletRequest request) throws Exception {
		RegionDTO dto = new RegionDTO();
		
		String id = request.getParameter("region_id");
		dto.setRegion_id(Integer.valueOf(id));
		
		dto = dao.getDetail(dto);
		request.setAttribute("dto", dto);
		
		return "regions/detail";
	}
}
