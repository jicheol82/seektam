package com.cjc.seektam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjc.seektam.model.MemberDTO;
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
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/loginForm";
	}
	
	@RequestMapping("/loginpro")
	public String loginPro(MemberDTO dto, Model model) throws Exception {
		int result = memberService.idPwCheck(dto);
		model.addAttribute("result", result);
		return "member/loginPro";
	}
		
	@RequestMapping("/signup")
	public String signup() {
		return "member/signupForm";
	}
	
	@RequestMapping("/signuppro")
	public String signupPro(MemberDTO dto) throws Exception {
		memberService.addMember(dto);
		return "member/signupPro";
	}
	
	@RequestMapping("/confirmid")
	public String confirmId(String id, Model model) throws Exception{
		int check = memberService.idCheck(id);
		model.addAttribute("check", check);
		model.addAttribute("trialId", id);
		return "member/confirmId";
	}
	
}
