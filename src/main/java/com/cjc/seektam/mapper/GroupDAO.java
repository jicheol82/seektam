package com.cjc.seektam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupDAO {
	List findMyGr(String userId);
	List findGrMember(List myGrList);
}
