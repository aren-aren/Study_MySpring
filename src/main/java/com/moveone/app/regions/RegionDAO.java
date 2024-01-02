package com.moveone.app.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studyservlet.app.util.DBConnector;

public class RegionDAO {
	
	public int update(RegionDTO regionDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "UPDATE REGIONS SET REGION_NAME=? WHERE REGION_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, regionDTO.getRegion_name());
		st.setInt(2, regionDTO.getRegion_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	public int add(RegionDTO regionDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "INSERT INTO REGIONS VALUES(?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}

	public List<RegionDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM REGIONS";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<RegionDTO> regions = new ArrayList<RegionDTO>();
		
		while(rs.next()) {
			RegionDTO dto = new RegionDTO();
			dto.setRegion_id(rs.getInt("REGION_ID"));
			dto.setRegion_name(rs.getString("REGION_NAME"));
			regions.add(dto);
		}
		
		DBConnector.disConnect(rs, st, con);
	
		return regions;
	}
	
	public RegionDTO getDetail(RegionDTO dto) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID = ?";
		//name
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getRegion_id());
		
		ResultSet rs = st.executeQuery();
		
		RegionDTO regionDTO = null;
		if(rs.next()) {
			regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getInt("REGION_ID"));
			regionDTO.setRegion_name(rs.getString("REGION_NAME"));
		}
		
		return regionDTO;
	}
	
}
