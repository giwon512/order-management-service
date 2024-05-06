package com.mysite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mysite.domain.Login;
import com.mysite.domain.Menu;

@Mapper
public interface MapperInterface {
	
	@Select("select * from menulist")
	List<Menu> getMenuList();
	
//	@Insert("insert into customer values(#{tel}, #{tblNum})")
//	int newCustomer(Customer customer);
}
