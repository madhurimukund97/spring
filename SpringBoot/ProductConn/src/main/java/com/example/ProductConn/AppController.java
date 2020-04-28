package com.example.ProductConn;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AppController {
	@Autowired
	private ProductService ser;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> li = ser.listAll();
		model.addAttribute("li", li);
		
		return "index";
	
	}
	
	
}
