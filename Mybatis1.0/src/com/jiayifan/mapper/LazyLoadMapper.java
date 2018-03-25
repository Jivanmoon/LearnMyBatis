package com.jiayifan.mapper;
import java.util.List;

import com.jiayifan.po.*;
public interface LazyLoadMapper {
	public List<Orders> findOrdersLazyLoad() throws Exception;

}
