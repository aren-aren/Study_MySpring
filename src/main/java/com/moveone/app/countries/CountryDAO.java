package com.moveone.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studyservlet.app.util.DBConnector;

public class CountryDAO {
	public List<CountryDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM COUNTRIES";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<CountryDTO> countries = new ArrayList<CountryDTO>();
		
		while(rs.next()) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countryDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countryDTO.setRegion_id(rs.getInt("REGION_ID"));
			countries.add(countryDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
	
		return countries;
	}
	
	public CountryDTO getDetail(CountryDTO dto) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getCountry_id());
		
		ResultSet rs = st.executeQuery();
		
		CountryDTO countryDTO = null;
		if(rs.next()) {
			countryDTO = new CountryDTO();

			countryDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countryDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countryDTO.setRegion_id(rs.getInt("REGION_ID"));
		}
		
		return countryDTO;
	}
	
	
}
