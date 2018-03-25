package com.jiayifan.mapper;
import java.util.List;

import com.jiayifan.po.*;
public interface OneToOneMapper {
	public List<OrdersCustom> findOrdersList() throws Exception;
	public List<Orders> findOrdersListResultMap() throws Exception;
}
