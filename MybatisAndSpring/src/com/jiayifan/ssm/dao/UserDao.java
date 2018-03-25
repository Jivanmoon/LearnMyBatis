package com.jiayifan.ssm.dao;

import com.jiayifan.ssm.po.User;

/**
 * dao接口，用户管理
 * @author 贾一帆
 *
 */
public interface UserDao {
	//根据ID查询用户信息
	public User findUserById(int id) throws Exception;
}
