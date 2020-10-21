package store.eazychina.wtx.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import store.eazychina.wtx.exception.SSMException;
import store.eazychina.wtx.model.Attachment;


public interface IAttachmentService {
	/**
	 * 文件对象
	 * 
	 * @param attachment
	 * @param inputStream
	 */
	public void add( MultipartFile  file,String filePath) throws SSMException;

	public void delete(int id,String filePath);

	public List<Attachment> list();
}
