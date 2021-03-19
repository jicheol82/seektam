package com.cjc.seektam.dao.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.seektam.dto.member.MemberDTO;

@Repository
public class MemberDAOImple implements MemberDAO {
	
	//sqlSession 주입받아 아래 메서드에서 sqlSession.se~사용
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Override
	public void insertMember(MemberDTO dto) throws Exception {
		sqlSession.insert("member.insertMember", dto);
	}

	@Override
	public int idPwCheck(MemberDTO dto) throws Exception {
		int result = sqlSession.selectOne("member.idPwCheck", dto);
		return result;
	}

	@Override
	public MemberDTO selectMember(String id) throws Exception {
		MemberDTO member = sqlSession.selectOne("member.selectMember", id);
		return member;
	}

	@Override
	public void updateMember(MemberDTO dto) throws Exception {
		sqlSession.update("member.updateMember", dto);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		sqlSession.delete("member.deleteMember", id);
	}

	@Override
	public int idAvailCheck(String id) throws Exception {
		int check = sqlSession.selectOne("member.idAvail", id);
		return check;
	}

}
