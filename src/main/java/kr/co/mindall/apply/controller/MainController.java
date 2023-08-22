package kr.co.mindall.apply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main")
	public String main(Model model) {
		model.addAttribute("home", "this is Your home page");
		return "login/main";
	}
}
