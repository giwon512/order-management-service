package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.domain.Menu;
import com.mysite.service.MenuService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/menuList")
	public String menuList(Model model) {
		List<Menu> list = menuService.getMenuList();
		if(list.size() == 0) {
			menuService.makeMenuList();
			list = menuService.getMenuList();
		}
		model.addAttribute("menuList", list);
		return "order/menuList";
	}
	
	@GetMapping("/orderList")
	public String pay() {
		return "order/orderList";
	}
	
	@GetMapping("/addList")
	public String addList(HttpServletRequest request, @RequestParam(value="menuNum") int menuNum) {
		
		List<Menu> list = menuService.setMenuList(menuNum);
		HttpSession session = request.getSession();
		session.setAttribute("orderList", list);
		
		int totalCost = 0;
		for(Menu menu : list) {
			totalCost += menu.getPrice();
		}
		
		session.setAttribute("totalCost", totalCost);
		
		//이전 페이지로 이동
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
	}
	
	@GetMapping("/removeList")
	public String removeList(HttpServletRequest request, @RequestParam(value="menuIdx") int menuIdx) {
		List<Menu> list = menuService.removeMenu(menuIdx);
		HttpSession session = request.getSession();
		session.setAttribute("orderList", list);
		
		int totalCost = 0;
		for(Menu menu : list) {
			totalCost += menu.getPrice();
		}
		
		session.setAttribute("totalCost", totalCost);
		
		
		//이전 페이지로 이동
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
	}
}
