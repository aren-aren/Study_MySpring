package com.moveone.app.product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/products/*")
public class ProductController {
	ProductDAO productDAO;
	
	public ProductController() {
		productDAO = new ProductDAO();
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<ProductDTO> list = productDAO.getList();
		model.addAttribute("list", list);
		
		return "products/list";
	}

	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(Long productNum, Model model) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(productNum);
		
		productDTO = productDAO.getDetail(productDTO);
		
		model.addAttribute("dto", productDTO);
		
		return "products/detail";
	}
}
