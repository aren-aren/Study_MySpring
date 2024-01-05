package com.moveone.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	@Autowired
	DepartmentDAO departmentDAO;

	public List<DepartmentDTO> getList() throws Exception {
		return departmentDAO.getList();
	}

	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.getDetail(departmentDTO);
	}

	public int add(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.add(departmentDTO);
	}
	
	
}
