package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.domain.Login;
import com.mysite.domain.Menu;
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
			return "management/manager";
		}
		else {
			//고객 등록
			HttpSession session = req.getSession();
			session.setAttribute("tel", loginInfo.getTel());
			session.setAttribute("tblNum", loginInfo.getTblNum());
			
			//메뉴 리스트 출력
			List<Menu> list = menuService.getMenuList();
			if(list.size() == 0) {
				menuService.makeMenuList();
				list = menuService.getMenuList();
			}
			
			model.addAttribute("menuList", list);
			return "order/menuList";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		return "index";
	}
}
