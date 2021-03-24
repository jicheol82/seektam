package com.cjc.seektam.dao.restaurant;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDAOImple implements RestaurantDAO {
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Override
	public void insertRestaurant() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRestaurant() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyRestaurant() {
		// TODO Auto-generated method stub

	}

	@Override
	public List getRestaurant(List idList) {
		List result = sqlSession.selectList("restaurant.selectRestaurant", idList);
		return result;
	}

	@Override
	public void insertResComment() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteResComment() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyResComment() {
		// TODO Auto-generated method stub

	}

	@Override
	public List getResComment(@Param("resId") String resId, @Param("myGrList") List myGrList) {
		List result = sqlSession.selectList("restaurant.getResComment");
		return null;
	}

	@Override
	public void insertResPoint() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteResPoint() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyResPoint() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getResPoint() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertAgreeRecord() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAgreeRecord() {
		// TODO Auto-generated method stub

	}

}
