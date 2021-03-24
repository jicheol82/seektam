package com.cjc.seektam.dao.group;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDAOimple implements GroupDAO {
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Override
	public List findMyGr(String userId) {
		List myGrList= sqlSession.selectList("group.findMyGr", userId);
		return myGrList;
	}

}
