package com.jiayifan.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jiayifan.po.*;

class UserMapperTest {
	private SqlSessionFactory sessionFactory;
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
	void testFindUserList() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		//得到UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用userMapper方法
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		//userCustom.setSex("1");
		//userCustom.setUsername("小明");
		//传入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(26);
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	void testFindUserResultMap() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		//得到UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用userMapper方法
		//创建包装对象，设置查询条件
		List<User> user = userMapper.findUserResultMap(1);
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	void testFindUserCount() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		//得到UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用userMapper方法
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		//userCustom.setSex("1");
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
		sqlSession.close();
	}
	
	@Test
	void testFindUserById() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		//得到UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用userMapper方法
		User user = userMapper.findUserById(28);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	void testFindUserByName() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		//得到UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用userMapper方法
		List<User> list = userMapper.findUserByName("%小明%");
		System.out.println(list);
		sqlSession.close();
	}

	@Test
	void testInsertUser() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		//得到UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用userMapper方法
		User user = new User();
		user.setUsername("朱奇瑞");
		user.setAddress("河南");
		user.setBirthday(new Date());
		user.setSex("1");
		userMapper.insertUser(user);
		sqlSession.commit();
		System.out.println(user.getId());
		sqlSession.close();
	}

	@Test
	void testDeleteUser() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		//得到UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用userMapper方法
		userMapper.deleteUser(27);
		sqlSession.commit();
		sqlSession.close();
	}
}
