package com.mysite.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.mysite.domain.Order;

@Mapper
public interface MapperInterface {
	
//	@Select("select * from menulist")
//	List<Menu> getMenuList();
	
//	@Insert("insert into customer values(#{tel}, #{tblNum})")
//	int newCustomer(Customer customer);
	
	@Insert("insert into orderlist values(order_num.nextVal, #{tblNum}, #{ordered}, #{cost}, sysdate)")
	int newOrder(Order order);
}
