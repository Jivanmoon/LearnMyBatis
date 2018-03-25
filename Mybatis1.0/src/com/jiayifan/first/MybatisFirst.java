package com.jiayifan.first;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.jiayifan.po.User;

/**
 * Mybatis入门程序
 * @author 贾一帆
 *
 */
public class MybatisFirst {
	//根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserById() throws IOException {
		//Mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlsession = sessionFactory.openSession();
		//通过SQLSession操作数据库
		//第一个参数就是映射文件中的statement的id，等于命名空间.id
		//第二个参数是映射文件中所匹配的parameterType类型参数
		//该函数运行最终的结果就是与你映射文件中所匹配的resoultType类型的对象
		User user = sqlsession.selectOne("test.findUserById", 1);
		System.out.println(user);
		//释放资源
		sqlsession.close();
	}
	//根据用户名称来模糊查询用户列表
	@Test
	public void findUserByName() throws IOException {
		//Mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlsession = sessionFactory.openSession();
		//通过SQLSession操作数据库
		//第一个参数就是映射文件中的statement的id，等于命名空间.id
		//第二个参数是映射文件中所匹配的parameterType类型参数
		//该函数运行最终的结果就是与你映射文件中所匹配的resoultType类型的对象
		List<User> list = sqlsession.selectList("test.findUserByName","小明");
		System.out.println(list);
		sqlsession.close();
	}
	@Test
	public void insertUser() throws IOException {
		//Mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlsession = sessionFactory.openSession();
		//通过SQLSession操作数据库
		//第一个参数就是映射文件中的statement的id，等于命名空间.id
		//第二个参数是映射文件中所匹配的parameterType类型参数
		//该函数运行最终的结果就是与你映射文件中所匹配的resoultType类型的对象
		//插入用户对象，先创建一个对象
		User user = new User();
		user.setUsername("贾一帆");
		user.setAddress("河南");
		user.setBirthday(new Date());
		user.setSex("1");
		sqlsession.insert("test.insertUser",user);
		//执行提交事务
		System.out.println(user.getId());
		sqlsession.commit();
		sqlsession.close();
	}
	@Test
	public void deleteUser() throws IOException {
		//Mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlsession = sessionFactory.openSession();
		//通过SQLSession操作数据库
		//第一个参数就是映射文件中的statement的id，等于命名空间.id
		//第二个参数是映射文件中所匹配的parameterType类型参数
		//传入id删除用户
		sqlsession.delete("test.deleteUser",28);
		sqlsession.commit();
		sqlsession.close();
		
	}
	@Test
	public void updateUser() throws IOException {
		//Mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlsession = sessionFactory.openSession();
		//通过SQLSession操作数据库
		//第一个参数就是映射文件中的statement的id，等于命名空间.id
		//第二个参数是映射文件中所匹配的parameterType类型参数
		User user = new User();
		user.setId(1);
		user.setBirthday(new Date());
		user.setUsername("hahaha");
		sqlsession.update("test.updateUser",user);
		sqlsession.commit();
		sqlsession.close();
	}
}
