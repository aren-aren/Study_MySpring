package com.moveone.app.regions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/regions/*")
public class RegionController {
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		System.out.println(request);
		System.out.println("Regions List");
		
		RegionDAO dao = new RegionDAO();
		List<RegionDTO> list = dao.getList();
		
		request.setAttribute("list", list);
		
		return "regions/list";
	}
	
}
