package com.moveone.app.product;

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
	public String list(Model model) {
		
		return "";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(Long productNum, Model model) {
		return "";
	}
}
