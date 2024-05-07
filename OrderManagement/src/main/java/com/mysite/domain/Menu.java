package com.mysite.domain;

import lombok.Data;

@Data
public class Menu {
	private int menuNum;
	private String name;
	private int price;
	
	public Menu() {}
	
	public Menu(int menuNum, String name, int price) {
		this.menuNum = menuNum;
		this.name = name;
		this.price = price;
	}
	
	
}
