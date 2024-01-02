package com.moveone.app.countries;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/countries/*")
public class CountryController {
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		System.out.println("Countries List");
		
		CountryDAO dao = new CountryDAO();
		List<CountryDTO> list = dao.getList();
		
		request.setAttribute("list", list);
		
		return "countries/list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(HttpServletRequest request) throws Exception {
		CountryDAO dao = new CountryDAO();
		CountryDTO dto = new CountryDTO();
		
		String id = request.getParameter("country_id");
		dto.setCountry_id(id);
		dto = dao.getDetail(dto);
		
		request.setAttribute("dto", dto);
		
		return "countries/detail";
	}
}
