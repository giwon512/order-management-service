package com.mysite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.domain.Menu;
import com.mysite.domain.Order;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MenuService {
	private static List<Menu> mainMenuList = new ArrayList<>();
	private static List<Menu> sideMenuList = new ArrayList<>();
	private static List<Menu> selectedList = new ArrayList<>();
	
	public void makeMenuList() {
		mainMenuList.add(new Menu(1, "오뎅탕", 16000));
		mainMenuList.add(new Menu(2, "나쵸", 12000));
		mainMenuList.add(new Menu(3, "김치전", 18000));
		mainMenuList.add(new Menu(4, "해물부추전", 19000));
		mainMenuList.add(new Menu(5, "만두", 8000));
		mainMenuList.add(new Menu(6, "순두부열라면", 7000));
		mainMenuList.add(new Menu(7, "오뎅탕&김치전 세트", 29000));
		mainMenuList.add(new Menu(8, "오뎅탕&해물부추전 세트", 30000));
		mainMenuList.add(new Menu(9, "해물부추전&김치전 세트", 34000));
		
		sideMenuList.add(new Menu(10, "김치", 1000));
		sideMenuList.add(new Menu(11, "물", 1000));
		sideMenuList.add(new Menu(12, "사이다", 3000));
		sideMenuList.add(new Menu(13, "콜라", 3000));
		sideMenuList.add(new Menu(14, "소주", 5000));
	}
	
	public List<Menu> getMainMenuList() {
		return mainMenuList;
	}
	
	public List<Menu> getSideMenuList() {
		return sideMenuList;
	}
	
	public List<Menu> getSelectedList() {
		return selectedList;
	}
	
	public List<Menu> setOrderMenuList(int menuNum){
//		System.out.println(menuNum);
//		System.out.println(selectedList);
		if(menuNum < 10) {
			selectedList.add(mainMenuList.get(menuNum - 1));
		}
		else {
			selectedList.add(sideMenuList.get(menuNum - 10));
		}
//		System.out.println(selectedList);
		return selectedList;
	}
	
	public void selectedListInit() {
		selectedList.clear();
	}
	
	public List<Menu> removeMenu(int idx) {
		selectedList.remove(idx);
		
		return selectedList;
	}
	
	public Order getOrderInfo(HttpServletRequest request) {
		Order newOrder = new Order();
		String ordered = "/";
		int cost = 0;
		for(Menu menu : selectedList) {
			ordered += menu.getMenuNum() + "/";
			cost += menu.getPrice();
		}
		
		String tblNum = (String)request.getSession().getAttribute("tblNum");
		
		newOrder.setCost(cost);
		newOrder.setOrdered(ordered);
		newOrder.setTblNum(Integer.parseInt(tblNum));
		
		return newOrder;
	}
}
