package com.jiayifan.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jiayifan.po.User;

/**
 * dao接口实现类
 * @author 贾一帆
 *
 */
public class UserDaoImpl implements UserDao {
	//需要向dao实现类注入SQLSessionFactory
	//这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory = null;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById",id);
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行插入操作
		sqlSession.insert("test.insertUser",user);
		System.out.println(user.getId());
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser",id);
		sqlSession.commit();
		sqlSession.close();
	}

}
