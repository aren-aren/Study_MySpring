package com.moveone.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studyservlet.app.util.DBConnector;

public class ProductDAO {
	
	public List<ProductDTO> getList() throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM PRODUCT";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ProductDTO dto = new ProductDTO();
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		if(rs.next()) {
			dto.setProductNum(rs.getLong("productNum"));
			dto.setProductName(rs.getString("productName"));
			dto.setProductContents(rs.getString("productNontents"));
			dto.setProductRate(rs.getDouble("productRate"));
			dto.setProductJumsu(rs.getDouble("productJumsu"));
			ar.add(dto);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM WHERE = PRODUCTNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, productDTO.getProductNum());
		ResultSet rs = st.executeQuery();
		
		productDTO.setProductContents(rs.getString("productContents"));
		productDTO.setProductJumsu(rs.getDouble("productJumsu"));
		productDTO.setProductName(rs.getString("productName"));
		productDTO.setProductNum(rs.getLong("productNum"));
		productDTO.setProductRate(rs.getDouble("productRate"));
		
		DBConnector.disConnect(rs, st, con);
		
		
		return productDTO;
	}
	
	public Integer addProduct(ProductDTO productDTO) {
		return null;
	}
	
	public Integer modifyProduct(ProductDTO productDTO) {
		return null;
	}
	
	public Integer deleteProduct(ProductDTO productDTO) {
		return null;
	}
}
