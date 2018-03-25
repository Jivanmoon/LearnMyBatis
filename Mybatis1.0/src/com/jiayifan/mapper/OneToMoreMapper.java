package com.jiayifan.mapper;

import java.util.List;

import com.jiayifan.po.*;
public interface OneToMoreMapper {
	public List<Orders> findOrdersDetailList () throws Exception;

}
