package com.moveone.app.regions;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moveone.app.util.Pager;

@Repository
public class RegionDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.moveone.app.regions.RegionDAO.";
	
	public int update(RegionDTO regionDTO) throws Exception {
		return sqlSession.update(namespace + "update", regionDTO);
	}
	
	public int add(RegionDTO regionDTO) throws Exception {
		return sqlSession.insert(namespace + "add", regionDTO);
	}

	public List<RegionDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(namespace + "getList", pager);
	}
	
	public RegionDTO getDetail(RegionDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + "getDetail", dto);
	}
	
	public int delete(RegionDTO regionDTO) throws Exception {
		return sqlSession.delete(namespace+"delete", regionDTO);
	}
	
	public Long getTotal(Pager pager) throws Exception {
		return sqlSession.selectOne(namespace + "getTotal", pager);
	}
	
}
