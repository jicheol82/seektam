package com.cjc.seektam.dao.restaurant;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.seektam.dto.restaurant.ResCommentDTO;

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
	public List getResComment(@Param("resId") Double resId, @Param("myGrList") List myGrList) {
		System.out.println("getComment dao in");
		System.out.println("res_id : "+resId);
		List<ResCommentDTO> result = sqlSession.selectList("restaurant.getResComment");
		System.out.println("result empty? "+result.isEmpty());
		System.out.println("result[0]? "+result.get(0));
		System.out.println("content? "+result.get(0).getComments());
		
		System.out.println("getComment dao out");
		return result;
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
