package store.eazychina.wtx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import store.eazychina.wtx.service.IUserService;
import store.eazychina.wtx.exception.SSMException;
import store.eazychina.wtx.model.User;



@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@RequestMapping("/list")
	public String list(HttpSession session, Model model) {
		List<User> users = userService.list();
		model.addAttribute("users", users);
		return "user/user/list";
	}
	@RequestMapping("userlogin")
	public String login(String username,String password, HttpSession session) throws SSMException {
		System.out.println("��ȡ���ݳɹ�");
		User user=new User(username, password);
		User loginUser = userService.login(user);
		session.setAttribute("loginUser", loginUser);
		return "redirect:/index";
	}
}
