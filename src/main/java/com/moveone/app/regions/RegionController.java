package com.moveone.app.regions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/regions/*")
public class RegionController {
	
	@Autowired
	private RegionService regionService;
	
//	public RegionController() {
//		this.dao = new RegionDAO();
//	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(RegionDTO dto, Model model) throws Exception {
		//int result = regionService.add(dto);
		
		String msg = "등록 실패";
		if ( false ){//result > 0 ) {
			//성공
			msg = "등록성공";
		}
		
//		request.setAttribute("msg", msg);
//		request.setAttribute("path", "./list"); 
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "regions/add";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list() throws Exception {
		System.out.println("Regions List");
		
		ModelAndView mv = new ModelAndView();
		
		List<RegionDTO> list = regionService.getList();
		
//		request.setAttribute("list", list);
		mv.addObject("list", list);
		mv.setViewName("regions/list");
		return mv;
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	//파라미터의 이름과 타입을 동일하게 선언
	public String detail(Integer region_id, Model model) throws Exception {
		RegionDTO dto = new RegionDTO();
		
		dto.setRegion_id(region_id);
		
		//dto = regionService.getDetail(dto);
		//request.setAttribute("dto", dto);
		//Model과 request의 라이프사이클이 동일
		model.addAttribute("dto", dto);
		
		return "regions/detail";
	}
}
