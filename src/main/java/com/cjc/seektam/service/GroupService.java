package com.cjc.seektam.service;

import java.util.List;
import java.util.Map;

import com.cjc.seektam.model.GroupsDTO;

public interface GroupService {
	Map group();
	List search(Map searchMap);
	int createMyGr(GroupsDTO groupsDTO);
}
