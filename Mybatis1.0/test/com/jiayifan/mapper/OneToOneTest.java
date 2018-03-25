package com.jiayifan.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jiayifan.po.Orders;
import com.jiayifan.po.OrdersCustom;

class OneToOneTest {
	private SqlSessionFactory sqlSessionFactory;
	@BeforeEach
	void setUp() throws Exception {
		//创建SqlSessionFactory
		//Mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	void testFindOrdersList() throws Exception {
		//获取session
        SqlSession session = sqlSessionFactory.openSession();
        //获限mapper接口实例
        OneToOneMapper oneToOneMapper = session.getMapper(OneToOneMapper.class);
        //查询订单信息
        List<OrdersCustom> list = oneToOneMapper.findOrdersList();
        System.out.println(list);
        //关闭session
        session.close();
	}
	@Test
	void testFindOrdersListResultMap() throws Exception {
		//获取session
        SqlSession session = sqlSessionFactory.openSession();
        //获限mapper接口实例
        OneToOneMapper oneToOneMapper = session.getMapper(OneToOneMapper.class);
        //查询订单信息
        List<Orders> list = oneToOneMapper.findOrdersListResultMap();
        System.out.println(list);
        //关闭session
        session.close();
	}
	

}
