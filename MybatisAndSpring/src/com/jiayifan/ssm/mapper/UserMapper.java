package com.jiayifan.ssm.mapper;

import java.util.List;

import com.jiayifan.ssm.po.User;

/**
 * mapper接口
 * @author 贾一帆
 *
 */
public interface UserMapper {
	//根据ID查询用户信息
	public User findUserById(int id) throws Exception;
	
}
