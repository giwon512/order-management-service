package com.mysite.domain;

import lombok.Data;

@Data
public class Order {
	private int orderNum;
	private int tblNum;
	private String ordered;
	private int cost;
	private String orderTime;
}
