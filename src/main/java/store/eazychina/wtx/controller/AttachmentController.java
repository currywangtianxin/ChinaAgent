package store.eazychina.wtx.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import store.eazychina.wtx.exception.SSMException;
import store.eazychina.wtx.service.IAttachmentService;


@Controller
@RequestMapping("/attach")
public class AttachmentController {
	@Autowired
	private IAttachmentService attachmentService;

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("attachments", attachmentService.list());
		return "attach/list";
	}

	@RequestMapping("/add")
	public String add() {
		return "attach/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(MultipartFile file, HttpServletRequest request)
			throws SSMException {
		String filePath = request.getServletContext().getRealPath(
				"/resources/upload");
		attachmentService.add(file, filePath);
		return "redirect:/attach/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,HttpServletRequest request){
		String filePath = request.getServletContext().getRealPath(
				"/resources/upload");
		attachmentService.delete(id, filePath);
		return "redirect:/attach/list";
	}
}
