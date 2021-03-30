package com.cjc.seektam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cjc.seektam.model.GroupsDTO;

@Mapper
public interface GroupDAO {
	List findMyGr(String userId);
	List findGrMember(@Param("myGrList") List myGrList);
	GroupsDTO selectMyGroup(String memId);
	List  
}
