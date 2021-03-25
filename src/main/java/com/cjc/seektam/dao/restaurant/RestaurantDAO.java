package com.cjc.seektam.dao.restaurant;

import java.util.List;

public interface RestaurantDAO {
	//CRUD
	//RESTAURANT에 record만들기
	public void insertRestaurant();
	//RESTAURANT에 record삭제
	public void deleteRestaurant();
	//RESTAURANT에 record수정
	public void modifyRestaurant();
	//RESTAURANT에 record가져오기
	public List getRestaurant(List idList);
	
	//RES_COMMENT에 record만들기
	public void insertResComment();
	//RES_COMMENT에 record삭제
	public void deleteResComment();
	//RES_COMMENT에 record수정
	public void modifyResComment();
	//RES_COMMENT에 record가져오기
	public List getResComment(Double resId, List myGrList);
	
	//RES_Point에 record만들기
	public void insertResPoint();
	//RES_Point에 record삭제
	public void deleteResPoint();
	//RES_Point에 record수정
	public void modifyResPoint();
	//RES_Point에 record가져오기
	public void getResPoint();
	
	//AGREE_RECORD에 record만들기
	public void insertAgreeRecord();
	//AGREE_RECORD에 record가져오기
	public void getAgreeRecord();
}
