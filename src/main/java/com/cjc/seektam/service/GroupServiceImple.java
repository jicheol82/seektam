package com.cjc.seektam.service;

import java.util.HashMap;
import java.util.List;
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
		Map groupMap = new HashMap();
		//memId가져오기
		String memId = memberService.getMemId();
		//내가 만든 그룹찾아 groupDTO에 넣어 가져오기-내가 만든 그룹은 1개
		GroupsDTO groupsDTO = groupDAO.selectMyGroup(memId);
		groupMap.put("groupsDTO", groupsDTO);
		//내가 가입한 그룹 찾기
		List joinedGrList = groupDAO.selectJoinedGr(memId);
		groupMap.put("joinedGrList", joinedGrList);
		return groupMap;
	}
	@Override
	public List search(Map searchMap) {
		String memId = memberService.getMemId();
		searchMap.put("memId", memId);
		List joinedGr = groupDAO.selectJoinedGr(memId);
		searchMap.put("joinedGr", joinedGr);
		List result = groupDAO.selectSearchGr(searchMap);
		return result;
	}
	@Override
	public int createMyGr(GroupsDTO groupsDTO) {
		String memId = memberService.getMemId();
		groupsDTO.setGroup_leader(memId);
		int result = groupDAO.insertMyGr(groupsDTO);
		return result;
	}

}
