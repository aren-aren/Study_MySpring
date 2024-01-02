package com.moveone.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studyservlet.app.util.DBConnector;

public class DepartmentDAO {
	
	public int update(DepartmentDTO dto) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ? , MANAGER_ID = ? , LOCATION_ID = ? WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getDepartment_name());
		st.setInt(2, dto.getManager_id());
		st.setInt(3, dto.getLocation_id());
		st.setInt(4, dto.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	public int add(DepartmentDTO dto) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "INSERT INTO DEPARTMENTS VALUES (?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getDepartment_id());
		st.setString(2, dto.getDepartment_name());
		st.setInt(3, dto.getManager_id());
		st.setInt(4, dto.getLocation_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	public List<DepartmentDTO> getList() throws Exception {
		//DB접속 후 부서테이블의 모든 정보를 출력
		/*
		 * 1. 접속 정보
		 * 2. DB연결
		 * 3. SQL문 생성
		 * 4. SQL문 미리 전송
		 * 5. ?값 세팅
		 * 6. 최종 전송 및 결과 처리
		 * 7. 자원 해제
		 */
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM DEPARTMENTS";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
		while(rs.next()) {
			DepartmentDTO dto = new DepartmentDTO();
			dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			dto.setManager_id(rs.getInt("MANAGER_ID"));
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
		
			list.add(dto);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return list;
	}
	
	public DepartmentDTO getDetail(DepartmentDTO dto) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, dto.getDepartment_id());
		
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO departmentDTO = null;
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
		}
		
		return departmentDTO;
	}
}
