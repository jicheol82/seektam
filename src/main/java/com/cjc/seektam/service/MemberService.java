package com.cjc.seektam.service;

import com.cjc.seektam.model.MemberDTO;

public interface MemberService {
	// session에서 memId 받기
	public String getMemId();
	// 회원가입
	public void addMember(MemberDTO dto);
	// 아이디 비번 확인
	public int idPwCheck(MemberDTO dto);
	// 회원 데이터 가져오기
	public MemberDTO getMember(String id);
	// 회원데이터수정
	public void modifyMember(MemberDTO dto);
	// 로그아웃
	public void logout();
	// 회원탈퇴
	public int deleteMember(MemberDTO dto) ;
	// 유효id확인
	public int idCheck(String id);
}
