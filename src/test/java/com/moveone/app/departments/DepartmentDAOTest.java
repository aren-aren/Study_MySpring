package com.moveone.app.departments;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;

public class DepartmentDAOTest extends MyTest{
	@Autowired
	DepartmentDAO departmentDAO;
	
	@Test
	public void getDetail() throws Exception {
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_id(10);
		
		dto = departmentDAO.getDetail(dto);
		
		assertNotNull(dto);
	}
	
	@Test
	public void getList() throws Exception {
		List<DepartmentDTO> list = departmentDAO.getList();
		
		assertNotEquals(0, list.size());
	}
}
