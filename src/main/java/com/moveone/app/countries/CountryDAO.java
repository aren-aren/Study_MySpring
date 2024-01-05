package com.moveone.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studyservlet.app.util.DBConnector;

@Repository
public class CountryDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.moveone.app.countries.CountryDAO.";
	
	public List<CountryDTO> getList() throws Exception {
		return sqlSession.selectList(namespace + "getList");
	}
	
	public CountryDTO getDetail(CountryDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + "getDetail", dto);
	}
	
	
}
