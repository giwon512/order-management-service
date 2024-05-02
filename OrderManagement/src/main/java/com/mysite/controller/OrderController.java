package com.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.domain.Customer;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping("/list")
	public String menuList(Customer customer) {
		if(customer.getTel().equals("system") && customer.getTblNum().equals("1111")) {
			return "management/manager";
		}
		else {
			return "order/menuList";
		}
		
	}
}
