package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/choice")
	public String pay() {
		return "order/choice";
	}
	
	@GetMapping("/addList")
	public String addList(HttpServletRequest request, @RequestParam(value="menuNum") int menuNum) {
		
		List<Menu> list = menuService.setMenuList(menuNum);
		HttpSession session = request.getSession();
		session.setAttribute("orderList", list);
		
		//이전 페이지로 이동
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
	}
}
