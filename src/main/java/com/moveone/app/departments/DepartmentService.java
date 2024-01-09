package com.moveone.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moveone.app.util.Pager;

@Service
public class DepartmentService {
	@Autowired
	DepartmentDAO departmentDAO;

	public List<DepartmentDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount = departmentDAO.getTotal();
		pager.makeNum(totalCount);
		return departmentDAO.getList(pager);
	}

	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.getDetail(departmentDTO);
	}

	public int add(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.add(departmentDTO);
	}
	
	
}
