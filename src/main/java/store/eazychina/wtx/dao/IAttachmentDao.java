package store.eazychina.wtx.dao;

import java.util.List;

import store.eazychina.wtx.model.Attachment;


public interface IAttachmentDao {
	public void add(Attachment attachment);

	public void delete(int id);

	public List<Attachment> list();
	
	public Attachment load(int id);
}
