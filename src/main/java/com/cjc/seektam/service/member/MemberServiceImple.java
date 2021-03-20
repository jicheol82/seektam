package com.cjc.seektam.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

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
		// id, pw로 check
		int result = memberDAO.idPwCheck(dto);
		// result 결과가 1이면 로근인 처리 하고 세션 생성
		if(result == 1) {
			setSessionAttr("memId", dto);
		}
		// result 결과가 0이면 로그인 실패
		return result;
	}
	
	private void setSessionAttr(String sessionName, MemberDTO dto) {
		// 세션생성은 controller에서 HttpSession session 매개변수 받아  전달 받던가(비추)
		// session.setAttribute(~~~)
		// RequestContextHolder를 사용하여 service에서 생성
		RequestContextHolder.getRequestAttributes().setAttribute("memId", dto.getId(), RequestAttributes.SCOPE_SESSION);
	}

	@Override
	public MemberDTO getMember(String id) throws Exception {
		MemberDTO member = memberDAO.selectMember(id);
		return member;
	}

	@Override
	public void modifyMember(MemberDTO dto) throws Exception {
		// 수정 : dto(pw, age, email) id추가 되어야 함(session에서 꺼내기)
		String id = (String)RequestContextHolder.getRequestAttributes().getAttribute("memId", RequestAttributes.SCOPE_SESSION);
		dto.setId(id);
		
		// RequestContextHolder : controller, service, dao 전구간에서
		// HttpServletRequest에 접근할 수 있도록 도와주는 클래스
		// request 객체 꺼내기
//		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//		ServletRequestAttributes sra = (ServletRequestAttributes)ra;
//		HttpServletRequest request = sra.getRequest();
//		HttpServletResponse resoponse = sra.getResponse();
		
		memberDAO.updateMember(dto);
	}

	@Override
	public int idCheck(String id) throws Exception {
		// 전달받은 id를 dao한테 던져주고 동일한id가 있는지 확인
		int check = memberDAO.idAvailCheck(id);
		return check;
	}

	@Override
	public void logout(String sessionName) throws Exception {
		removeSessionAttr(sessionName);
	}

	private void removeSessionAttr(String sessionName) {
		RequestContextHolder.getRequestAttributes().removeAttribute(sessionName, RequestAttributes.SCOPE_SESSION);
	}

	@Override
	public int deleteMember(MemberDTO dto) throws Exception {
		// db에 id, pw주고 이거 맞는지 확인 후
		// 결과에 따라 회원삭제 처리
		String id = (String) RequestContextHolder.getRequestAttributes().getAttribute("memId", RequestAttributes.SCOPE_SESSION);
		dto.setId(id);
		int result = memberDAO.idPwCheck(dto);
		// 맞으면 회원삭제 처리후 결과 리턴
		if(result==1) {
			memberDAO.deleteMember(id);
			removeSessionAttr("memId");
		}
		return result;
	}
}
