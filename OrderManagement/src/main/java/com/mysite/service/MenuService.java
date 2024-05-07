package com.mysite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.domain.Menu;

@Service
public class MenuService {
	private static List<Menu> menuList = new ArrayList<>();
	private static List<Menu> selectedList = new ArrayList<>();
	
	public void makeMenuList() {
		menuList.add(new Menu(1, "오뎅탕", 5000));
		menuList.add(new Menu(2, "라면", 3000));
		menuList.add(new Menu(3, "치킨", 12000));
		menuList.add(new Menu(4, "떡볶이", 8000));
		menuList.add(new Menu(5, "김치전", 5000));
		menuList.add(new Menu(6, "스테이크", 3000));
		menuList.add(new Menu(7, "골뱅이무침", 12000));
		menuList.add(new Menu(8, "감자칩", 8000));
		menuList.add(new Menu(9, "케첩", 89000));
	}
	
	public List<Menu> getMenuList() {
		return menuList;
	}
	
	public List<Menu> setMenuList(int menuNum){
		selectedList.add(menuList.get(menuNum - 1));
		
		return selectedList;
	}
	
	public void selectedListInit() {
		selectedList.clear();
	}
}
