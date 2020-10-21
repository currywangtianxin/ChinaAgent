package store.eazychina.wtx.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import store.eazychina.wtx.dao.IAttachmentDao;
import store.eazychina.wtx.exception.SSMException;
import store.eazychina.wtx.model.Attachment;
import store.eazychina.wtx.service.IAttachmentService;

@Service
public class AttachmentService implements IAttachmentService {
	
	@Autowired
	private IAttachmentDao attachmentDao;

	@Override
	public void add(MultipartFile file,String filePath) throws SSMException {
		InputStream inputStream = null;
		try {
			 inputStream = file.getInputStream();
			if (inputStream.available() <= 0) {
				throw new SSMException("");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String suffix = FilenameUtils.getExtension(file.getOriginalFilename());
		String oldName = FilenameUtils.getBaseName(file.getOriginalFilename());
		String newName = System.currentTimeMillis() + oldName
				+ (int) (Math.random() * 10000);
		long size = file.getSize();
		Attachment attachment = new Attachment(newName, oldName, size, suffix);
		attachmentDao.add(attachment);
		File destFile = new File(filePath+"/"+newName+"."+suffix);
		
		try {
			FileUtils.copyInputStreamToFile(inputStream, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id,String filePath) {
		Attachment attachment = attachmentDao.load(id);
		attachmentDao.delete(id);
		filePath+="/"+attachment.getNewName()+"."+attachment.getSuffix();
		File file = new File(filePath);
		file.delete();
	}

	@Override
	public List<Attachment> list() {
		return attachmentDao.list();
	}
}
