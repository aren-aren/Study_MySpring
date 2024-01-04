package com.moveone.app.departments;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAO {
	@Autowired
	SqlSession sqlSession;
	String namespace = "com.moveone.app.departments.DepartmentDAO.";
	
	public int update(DepartmentDTO dto) throws Exception {
		
		return 0;
	}
	
	public int add(DepartmentDTO dto) throws Exception {
		return 0;
	}
	
	public List<DepartmentDTO> getList() throws Exception {
		return sqlSession.selectList(namespace + "getList");
	}
	
	public DepartmentDTO getDetail(DepartmentDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + "getDetail", dto);
	}
}
