package com.jiayifan.dao;

import com.jiayifan.po.User;

/**
 * dao接口，用户管理
 * @author 贾一帆
 *
 */
public interface UserDao {
	//根据ID查询用户信息
	public User findUserById(int id) throws Exception;
	//添加用户信息
	public void insertUser(User user) throws Exception;
	//删除用户信息
	public void deleteUser(int id) throws Exception;
}
