package com.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping("/choice")
	public String pay() {
		return "order/choice";
	}
	
	@GetMapping("/addList")
	public String addList(HttpServletRequest request) {
		
		//이전 페이지로 이동
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
	}
}
