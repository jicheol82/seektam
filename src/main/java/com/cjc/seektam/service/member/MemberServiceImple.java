package com.cjc.seektam.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.seektam.dao.member.MemberDAO;
import com.cjc.seektam.dto.member.MemberDTO;

@Service
public class MemberServiceImple implements MemberService {
	// DAO 호출되게 자동주입
	@Autowired
	private MemberDAO memberDAO = null;
	@Override
	public void addMember(MemberDTO dto) throws Exception {
		memberDAO.insertMember(dto);
	}

	@Override
	public int idPwCheck(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO getMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyMember(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int idCheck(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void logout(String sessionName) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSessionAttr(String sessionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteMember(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
