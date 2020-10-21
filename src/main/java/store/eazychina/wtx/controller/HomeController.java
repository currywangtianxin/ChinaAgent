package store.eazychina.wtx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import store.eazychina.wtx.service.IUserService;
import store.eazychina.wtx.model.User;
@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private IUserService userService;
	@RequestMapping("/homepage2")
	public String homepage(HttpSession session, Model model) {
		List<User> users = userService.list();
		model.addAttribute("users", users);
		return "/home/homepage2";
	}
	
}
