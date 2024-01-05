package com.moveone.app.departments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;

public class DepartmentDAOTest extends MyTest{
	@Autowired
	DepartmentDAO departmentDAO;
	
	//@Test
	public void getDetail() throws Exception {
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_id(290);
		
		dto = departmentDAO.getDetail(dto);
		
		assertNotNull(dto);
	}
	
	@Test
	public void getList() throws Exception {
		List<DepartmentDTO> list = departmentDAO.getList();
		
		assertNotEquals(0, list.size());
	}
	
	//@Test
	public void addTest() throws Exception {
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_name("DevOps");
		dto.setManager_id(204);
		dto.setLocation_id(1500);
		
		int result = departmentDAO.add(dto);
		
		assertNotEquals(0, result);
	}
	
	//@Test
	public void updateTest() throws Exception {
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_id(290);
		
		dto = departmentDAO.getDetail(dto);
		
		dto.setLocation_id(2000);
		dto.setManager_id(121);
		
		int result = departmentDAO.update(dto);
		
		assertNotEquals(0, result);
	}
	
	@Test
	public void deleteTest() throws Exception {
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_id(290);
		
		int result = departmentDAO.delete(dto);
		
		assertEquals(1, result);
	}
}
