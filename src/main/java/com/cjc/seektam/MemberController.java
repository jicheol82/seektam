package com.cjc.seektam;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjc.seektam.model.MemberDTO;
import com.cjc.seektam.service.MemberService;


@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/loginForm";
	}
	
	@RequestMapping("/loginpro")
	public String loginPro(MemberDTO dto, Model model) {
		int result = memberService.idPwCheck(dto);
		model.addAttribute("result", result);
		return "member/loginPro";
	}
		
	@RequestMapping("/signup")
	public String signup() {
		return "member/signupForm";
	}
	
	@RequestMapping("/signuppro")
	public String signupPro(MemberDTO dto) {
		memberService.addMember(dto);
		return "member/signupPro";
	}
	// 유효id확인 (백앤드 구현o, 프론트구현 x)
	@RequestMapping("/confirmid")
	public String confirmId(String id, Model model){
		int check = memberService.idCheck(id);
		model.addAttribute("check", check);
		model.addAttribute("trialId", id);
		return "member/confirmId";
	}
	
	@RequestMapping("/logout")
	public String logout() throws Exception {
		// 세션 지우는 서비스 메서드 호출, 내가 지울 세션이름 던져주기
		// 로그아웃 뿐만 아니라
		// 만약에 세션에 저장된 다른 속성을 지울때 같은 메서드 이용 가능
		memberService.logout();
		return "member/logout";
	}
	
	@RequestMapping("/deleteaccount")
	public String deleteAccount() {
		return "member/deleteForm";
	}
	
	@RequestMapping("/deleteaccountpro")
	public String deleteAccountPro(MemberDTO dto, Model model) {
		int result = memberService.deleteMember(dto);
		model.addAttribute("result", result);
		return "member/deletePro";
	}
	
	@RequestMapping("/myaccount")
	public String myAccount(HttpSession session, Model model) {
		// 해당 회원의 정보 가져오기
		String memId = (String)session.getAttribute("memId");
		//HttpSession을 사용할 수 있다는 것도 보여주기위해 이렇게 사용되었지만
		//memberservcie에서 RequestContextHolder로 받아 처리하는게
		//깔끔해 보인다
		MemberDTO member = memberService.getMember(memId);
		model.addAttribute("member", member);
		return "member/modifyForm";
	}
	
	@RequestMapping("/myaccountpro")
	public String myAccountPro(MemberDTO dto) {
		//ajax가 아닌 정상적인 http통신으로 하면 매개변수 받기가 편함
		memberService.modifyMember(dto);
		return "member/modifyPro";
	}
}
