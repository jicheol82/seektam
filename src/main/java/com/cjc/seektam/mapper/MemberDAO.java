package com.cjc.seektam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cjc.seektam.model.MemberDTO;


@Mapper
public interface MemberDAO {
	//CRUD
	//회원가입
	public void insertMember(MemberDTO dto) throws Exception;
	//아이디 비번 확인
	public int idPwCheck(MemberDTO dto) throws Exception;
	//회원 한명 데이터 조회
	public MemberDTO selectMember(String id) throws Exception;
	//회원정보수정
	public void updateMember(MemberDTO dto) throws Exception;
	//회원탈퇴
	public void deleteMember(String id) throws Exception;
	//아이디 사용가능 여부
	public int idAvailCheck(String id) throws Exception;
}
