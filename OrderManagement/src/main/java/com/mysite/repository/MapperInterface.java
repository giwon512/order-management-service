package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.domain.Order;

@Mapper
public interface MapperInterface {
	
//	@Select("select * from menulist")
//	List<Menu> getMenuList();
	
//	@Insert("insert into customer values(#{tel}, #{tblNum})")
//	int newCustomer(Customer customer);
	
	@Insert("insert into orderlist values(order_num.nextVal, #{tblNum}, #{ordered}, #{cost}, sysdate, 'N')")
	int newOrder(Order order);
	
	@Select("select * from orderlist where state = 'N' order by orderNum desc")
	List<Order> getOrderList();
	
	@Update("update orderlist set state='Y' where orderNum=#{orderNum}")
	int updateOrder(int orderNum);
}
