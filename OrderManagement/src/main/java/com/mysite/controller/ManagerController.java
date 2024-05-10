package com.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.repository.MapperInterface;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private MapperInterface interFace;
	
	@GetMapping("/updateList")
	public String updateList(HttpServletRequest req, @RequestParam(value="orderNum") int orderNum) {
		interFace.updateOrder(orderNum);
		
		String referer = req.getHeader("Referer");
		return "redirect:" + referer;
	}
}
