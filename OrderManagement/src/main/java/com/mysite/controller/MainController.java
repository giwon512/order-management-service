package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.domain.Login;
import com.mysite.domain.Menu;
import com.mysite.domain.Order;
import com.mysite.repository.MapperInterface;
import com.mysite.service.MenuService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/main")
public class MainController {
	@Autowired
	private MapperInterface interFace;
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/login")
	public String login(Login loginInfo, Model model, HttpServletRequest req) {

		//로그인 결과에 따라 페이지 이동
		if(loginInfo.getTel().equals("system") && loginInfo.getTblNum().equals("1111")) {
			List<Order> orderList = interFace.getOrderList();
			model.addAttribute("orderList", orderList);
			
			return "management/manager";
		}
		else {
			//고객 등록
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(10*60);
			session.setAttribute("tel", loginInfo.getTel());
			session.setAttribute("tblNum", loginInfo.getTblNum());
			
			//메뉴 리스트 출력
			List<Menu> mainMenuList = menuService.getMainMenuList();
			List<Menu> sideMenuList = menuService.getSideMenuList();
			if(mainMenuList.size() == 0 || sideMenuList.size() == 0) {
				menuService.makeMenuList();
				mainMenuList = menuService.getMainMenuList();
				sideMenuList = menuService.getSideMenuList();
				session.setAttribute("orderList", null);
				menuService.selectedListInit();
			}
			
			model.addAttribute("mainMenuList", mainMenuList);
			model.addAttribute("sideMenuList", sideMenuList);
			return "order/menuList";
		} 	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		return "index";
	}
}
