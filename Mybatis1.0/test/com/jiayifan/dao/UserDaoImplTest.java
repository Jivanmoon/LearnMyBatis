package com.jiayifan.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jiayifan.po.User;

class UserDaoImplTest {
	private SqlSessionFactory sessionFactory;
	//此方法是在所有方法执行之前执行
	@BeforeEach
	void setUp() throws Exception {
		//创建SqlSessionFactory
		//Mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	void testFindUserById() throws Exception {
		//创建一个UserDao对象
		UserDao userDao = new UserDaoImpl(sessionFactory);
		//调用UserDao方法
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}
