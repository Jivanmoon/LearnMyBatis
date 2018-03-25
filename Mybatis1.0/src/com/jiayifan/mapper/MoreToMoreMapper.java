package com.jiayifan.mapper;
import java.util.List;

import com.jiayifan.po.*;
public interface MoreToMoreMapper {
	public List<User> findUserAndItemsResultMap() throws Exception;
}
