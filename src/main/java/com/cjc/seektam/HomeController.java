package com.cjc.seektam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cjc.seektam.dto.member.MemberDTO;
import com.cjc.seektam.service.member.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// 비즈니스 처리 요청 -> service 객체 필요
	@Autowired
	private MemberService memberService = null;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/loginForm";
	}
	
	@RequestMapping("/loginPro")
	public String loginPro() {
		return "member/loginPro";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "member/logout";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "member/signupForm";
	}
	
	@RequestMapping("/signupPro")
	public String signupPro(MemberDTO dto) throws Exception {
		memberService.addMember(dto);
		return "signupPro";
	}
	
	@RequestMapping("/deleteAccount")
	public String deleteAccount() {
		return "member/deleteForm";
	}
	
	@RequestMapping("/deleteAccountPro")
	public String deleteAccountPro() {
		return "member/deletePro";
	}
	
	@RequestMapping("/confirmId")
	public String confirmId() {
		return "member/confirmId";
	}
	
	@RequestMapping("/myAccount")
	public String myAccount() {
		return "member/modifyForm";
	}
	
	@RequestMapping("/myAccountPro")
	public String myAccountPro() {
		return "member/modifyPro";
	}
	
	
	
	
	
}
