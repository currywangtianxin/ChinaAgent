package store.eazychina.wtx.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import store.eazychina.wtx.dao.IUserDao;
import store.eazychina.wtx.model.User;


@Repository
public class UserDao extends SqlSessionDaoSupport implements IUserDao {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sessionFactory) {
		super.setSqlSessionFactory(sessionFactory);
	}

	@Override
	public User loadByUsername(String username) {
		// getSqlSession().selectOne("com.tledu.zrz.dao.IUserDao.loadByUsername",
		// username);
		return getSqlSession().getMapper(IUserDao.class).loadByUsername(
				username);
	}
	
	@Override
	public User loadByEmail(String email) {
		System.out.println(getSqlSession().getMapper(IUserDao.class).loadByEmail(email)+"  Dao���ȡ:loadByEmail  "  );
		return getSqlSession().getMapper(IUserDao.class).loadByEmail(email);
	}

	@Override
	public List<User> list() {
		return getSqlSession().getMapper(IUserDao.class).list();
	}

	@Override
	public void add(User user) {
		getSqlSession().getMapper(IUserDao.class).add(user);

	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IUserDao.class).delete(id);
	}



}
