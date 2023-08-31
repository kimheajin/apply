package kr.co.mindall.apply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mindall.apply.security.dto.MngAccount;
import kr.co.mindall.apply.service.MngService;

@Controller
public class MngController {

	@Autowired
	private MngService mngService;
	
	@RequestMapping("/login")
	public String signupPage() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication instanceof AnonymousAuthenticationToken)
        return "login/loginPage";
//        return "redirect:/";
	}
	
//	@RequestMapping("/loginProcess")
//	public String loginProc(@RequestParam String id, @RequestParam String password, Model model) {
//		MngAccount mngAccount = new MngAccount();
//		mngAccount.setMngId(id);
//		mngAccount.setMngPw(password);
//		MngAccount successRslt = mngService.getUser(mngAccount); 
//
//		if (successRslt != null) {
//			model.addAttribute("mngAccount", successRslt);
//			return "login/loginSuccess";
//		} else {
//			return "redirect:/login";
//		}
//	}
	
//	@RequestMapping("/joinProcess")
//	public String join(MngAccount mngAccount) {
//		mngAccount.setRole("ROLE_ADMIN");
//		mngService.createUser(mngAccount);
//		return "/redirect:/";
//	}
}
