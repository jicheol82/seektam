package com.cjc.seektam.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.seektam.mapper.GroupDAO;
import com.cjc.seektam.model.GroupsDTO;

@Service
public class GroupServiceImple implements GroupService {
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private MemberService memberService;
	@Override
	public Map group() {
		Map result = new HashMap();
		//memId가져오기
		String memId = memberService.getMemId();
		//내그룹찾아 groupDTO에 넣어 가져오기
		GroupsDTO groupsDTO = groupDAO.selectMyGroup(memId);
		result.put("groupsDTO", groupsDTO);
		//내가 가입한 그룹 찾아
		groupDAO.findMyGr(memId);
		return null;
	}

}
