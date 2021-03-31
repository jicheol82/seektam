package com.cjc.seektam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cjc.seektam.model.GroupsDTO;

@Mapper
public interface GroupDAO {
	List findMyGr(String userId);
	List findGrMember(@Param("myGrList") List myGrList);
	GroupsDTO selectMyGroup(String memId);
	List selectJoinedGr(String memId);
	List selectSearchGr(Map searchMap);
	int insertMyGr(GroupsDTO groupsDTO);
}
