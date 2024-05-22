package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.domain.Menu;
import com.mysite.domain.Order;
import com.mysite.repository.MapperInterface;
import com.mysite.service.MenuService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private MapperInterface interFace;
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/menuList")
	public String menuList(Model model, HttpServletRequest req) {
		if(req.getSession().getAttribute("tblNum") == null) {
			return "order/Error";
		}
		List<Menu> mainMenuList = menuService.getMainMenuList();
		List<Menu> sideMenuList = menuService.getSideMenuList();
		if(mainMenuList.size() == 0 || sideMenuList.size() == 0) {
			menuService.makeMenuList();
			mainMenuList = menuService.getMainMenuList();
			sideMenuList = menuService.getSideMenuList();
		}
		
		model.addAttribute("mainMenuList", mainMenuList);
		model.addAttribute("sideMenuList", sideMenuList);
		return "order/menuList";
	}
	
	@GetMapping("/orderList")
	public String orderList(HttpServletRequest req) {
		if(req.getSession().getAttribute("tblNum") == null) {
			return "order/Error";
		}
		List<Menu> list = menuService.getSelectedList();
		int totalCost = 0;
		for(Menu menu : list) {
			totalCost += menu.getPrice();
		}
		
		req.getSession().setAttribute("totalCost", totalCost);
		return "order/orderList";
	}
	
	@GetMapping("/addList")
	public String addList(HttpServletRequest request, @RequestParam(value="menuNum") int menuNum) {
//		System.out.println("in addList");
//		System.out.println("check : " + menuService.getSelectedList());
		List<Menu> list = menuService.setOrderMenuList(menuNum);
//		System.out.println(list);
		HttpSession session = request.getSession();
		if(session.getAttribute("tblNum") == null) {
			return "order/Error";
		}
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
		
		if(session.getAttribute("tblNum") == null) {
			return "order/Error";
		}
		
		int totalCost = 0;
		for(Menu menu : list) {
			totalCost += menu.getPrice();
		}
		
		session.setAttribute("totalCost", totalCost);
		
		
		//이전 페이지로 이동
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
	}
	
	@GetMapping("/pay")
	public String pay(Model model, HttpServletRequest req) {
		//주문 정보 DB에 저장
		if(req.getSession().getAttribute("tblNum") == null) {
			return "order/Error";
		}
		
		Order newOrder = menuService.getOrderInfo(req);
		if(newOrder.getCost() == 0) {
			return "order/orderList";
		}
		interFace.newOrder(newOrder);
		
		//저장된 세션 정보들 초기화 
		menuService.selectedListInit();
		
//		req.getSession().setAttribute("totalCost", 0);
		return "index";
	}
}
