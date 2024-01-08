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

import com.moveone.app.util.Pager;

@Controller
@RequestMapping(value="/regions/*")
public class RegionController {
	
	@Autowired
	private RegionService regionService;
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(RegionDTO dto, Model model) throws Exception {
		int result = regionService.add(dto);
		
		String msg = "등록 실패";
		if (result > 0 ) {
			msg = "등록성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "regions/add";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception {
		System.out.println("Regions List");
		
		ModelAndView mv = new ModelAndView();
		List<RegionDTO> list = regionService.getList(pager);
		
		mv.addObject("list", list);
		mv.setViewName("regions/list");
		return mv;
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	//파라미터의 이름과 타입을 동일하게 선언
	public String detail(RegionDTO dto, Model model) throws Exception {
		
		dto = regionService.getDetail(dto);
		model.addAttribute("dto", dto);
		
		return "regions/detail";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(RegionDTO regionDTO, Model model) throws Exception {
		int result = regionService.delete(regionDTO);
		
		String msg = regionDTO.getRegion_id() +  " : 삭제 실패";
		if (result > 0 ) {
			msg = regionDTO.getRegion_id() +  " : " + result + " 개 삭제 성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(RegionDTO regionDTO, Model model) throws Exception {
		regionDTO = regionService.getDetail(regionDTO);
		
		model.addAttribute("dto", regionDTO);
		
		return "regions/update";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(RegionDTO regionDTO, ModelAndView mv) throws Exception {
		int result = regionService.update(regionDTO);
		
		String msg = regionDTO.getRegion_id() +  " : 수정 실패";
		if (result > 0 ) {
			msg = regionDTO.getRegion_id() +  " : 수정 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./list");
		
		mv.setViewName("commons/result");
		
		return mv;
	}
}
