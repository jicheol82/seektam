package com.cjc.seektam;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjc.seektam.service.member.MemberService;

import com.cjc.seektam.dto.member.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService = null;
	
	@RequestMapping("/logout")
	public String logout() throws Exception {
		// 세션 지우는 서비스 메서드 호출, 내가 지울 세션이름 던져주기
		// 로그아웃 뿐만 아니라
		// 만약에 세션에 저장된 다른 속성을 지울때 같은 메서드 이용 가능
		memberService.logout("memId");
		return "member/logout";
	}
	
	@RequestMapping("/deleteaccount")
	public String deleteAccount() {
		return "member/deleteForm";
	}
	
	@RequestMapping("/deleteaccountpro")
	public String deleteAccountPro(MemberDTO dto, Model model) throws Exception {
		int result = memberService.deleteMember(dto);
		model.addAttribute("result", result);
		return "member/deletePro";
	}
	@RequestMapping("/myaccount")
	public String myAccount(HttpSession session, Model model) throws Exception {
		// 해당 회원의 정보 가져오기
		MemberDTO member = memberService.getMember((String)session.getAttribute("memId"));
		model.addAttribute("member", member);
		return "member/modifyForm";
	}
	
	@RequestMapping("/myaccountpro")
	public String myAccountPro(MemberDTO dto) throws Exception {
		memberService.modifyMember(dto);
		return "member/modifyPro";
	}
}
