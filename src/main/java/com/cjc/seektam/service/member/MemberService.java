package com.cjc.seektam.service.member;

import com.cjc.seektam.dto.member.MemberDTO;

public interface MemberService {
	//회원가입
	public void addMember(MemberDTO dto) throws Exception;
	// 아이디 비번 확인
	public int idPwCheck(MemberDTO dto) throws Exception;
	// 회원 데이터 가져오기
	public MemberDTO getMember(String id) throws Exception;
	// 회원데이터수정
	public void modifyMember(MemberDTO dto) throws Exception;
	// 아이디 사용가능 여부
	public int idCheck(String id) throws Exception;
	// 로그아웃
	public void logout(String sessionName) throws Exception;
	// 회원탈퇴
	public int deleteMember(MemberDTO dto) throws Exception;
}
