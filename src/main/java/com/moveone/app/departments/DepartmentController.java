package com.moveone.app.departments;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/departments/*")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<DepartmentDTO> list = departmentService.getList();
		
		model.addAttribute("list", list);
		
		return "departments/list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(DepartmentDTO departmentDTO, Model model) throws Exception {
		departmentDTO = departmentService.getDetail(departmentDTO);
		
		model.addAttribute("dto", departmentDTO);
		
		return "departments/detail";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() throws Exception {
		return "departments/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(DepartmentDTO departmentDTO, Model model) throws Exception {
		int result = departmentService.add(departmentDTO);
		
		String msg = "등록 실패";
		if(result > 0) {
			msg = "등록 성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
}
