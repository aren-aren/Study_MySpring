package com.moveone.app.departments;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moveone.app.util.Pager;

@Repository
public class DepartmentDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.moveone.app.departments.DepartmentDAO.";
	
	public int update(DepartmentDTO dto) throws Exception {
		return sqlSession.update(namespace+"update", dto);
	}
	
	public int add(DepartmentDTO dto) throws Exception {
		return sqlSession.insert(namespace + "add", dto);
	}
	
	public List<DepartmentDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(namespace + "getList", pager);
	}
	
	public DepartmentDTO getDetail(DepartmentDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + "getDetail", dto);
	}
	
	public int delete(DepartmentDTO departmentDTO) throws Exception {
		return sqlSession.delete(namespace+"delete", departmentDTO);
	}

	public Long getTotal() {
		return sqlSession.selectOne(namespace + "getTotal");
	}
}
