package com.jiayifan.mapper;

import java.util.List;

import com.jiayifan.po.User;
import com.jiayifan.po.UserCustom;
import com.jiayifan.po.UserQueryVo;

/**
 * mapper接口
 * @author 贾一帆
 *
 */
public interface UserMapper {
	//ResultMap使用
	public List<User> findUserResultMap(int id) throws Exception;
	//用户信息的综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	//用户信息的综合查询总数
		public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	//根据ID查询用户信息
	public User findUserById(int id) throws Exception;
	//根据name查询用户信息
	public List<User> findUserByName(String name) throws Exception;
	//添加用户信息
	public void insertUser(User user) throws Exception;
	//删除用户信息
	public void deleteUser(Integer id) throws Exception;
	public void updateUser(User user) throws Exception;
}
