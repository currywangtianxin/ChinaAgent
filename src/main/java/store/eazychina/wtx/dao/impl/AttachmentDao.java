package store.eazychina.wtx.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import store.eazychina.wtx.dao.IAttachmentDao;
import store.eazychina.wtx.model.Attachment;

@Repository
public class AttachmentDao extends SqlSessionDaoSupport implements
IAttachmentDao {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sessionFactory) {
		super.setSqlSessionFactory(sessionFactory);
	}

	@Override
	public void add(Attachment attachment) {
		getSqlSession().getMapper(IAttachmentDao.class).add(attachment);
	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IAttachmentDao.class).delete(id);

	}

	@Override
	public List<Attachment> list() {

		return getSqlSession().getMapper(IAttachmentDao.class).list();
	}

	@Override
	public Attachment load(int id) {
		return getSqlSession().getMapper(IAttachmentDao.class).load(id);
	}

}
