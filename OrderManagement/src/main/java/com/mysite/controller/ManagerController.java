package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.domain.Order;
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
	
	@GetMapping("/totalOrder")
	public String tatalOrder(Model model) {
		List<Order> orderList = interFace.getAllOrderList();
		int totalCost = 0;
		
		for(Order order : orderList) { 
			totalCost += order.getCost();
		}
		model.addAttribute("totalCost", totalCost);
		model.addAttribute("orderList", orderList);
		
		return "management/totalOrder";
	}
	
	@GetMapping("/back")
	public String back(Model model) {
		List<Order> orderList = interFace.getOrderList();
		model.addAttribute("orderList", orderList);
		
		return "management/manager";
	}
}
