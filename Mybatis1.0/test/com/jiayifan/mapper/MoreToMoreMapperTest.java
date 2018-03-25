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

import com.jiayifan.po.User;

class MoreToMoreMapperTest {

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
	void testFindUserAndItemsResultMap() throws Exception {
		//获取session
        SqlSession session = sqlSessionFactory.openSession();
        //获限mapper接口实例
        MoreToMoreMapper moreToMoreMapper = session.getMapper(MoreToMoreMapper.class);
        List<User> list = moreToMoreMapper.findUserAndItemsResultMap();
        System.out.println(list);
        session.close();
	}

}
