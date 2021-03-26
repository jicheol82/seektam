package com.cjc.seektam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cjc.seektam.model.AgreeRecordDTO;

@Mapper
public interface RestaurantDAO {
	//CRUD
	//RESTAURANT에 record만들기
	void insertRestaurant();
	//RESTAURANT에 record삭제
	void deleteRestaurant();
	//RESTAURANT에 record수정
	void updateRestaurant();
	//RESTAURANT에 record가져오기
	List selectRestaurant(List idList);
	
	//RES_COMMENT에 record만들기
	void insertResComment();
	//RES_COMMENT에 record삭제
	void deleteResComment();
	//RES_COMMENT에 record수정
	void updateResComment(Map map);
	//RES_COMMENT에 record가져오기
	List selectResComment0(@Param("resId")String resId);
	List selectResComment1(@Param("resId")String resId, @Param("myGrMembers") List myGrMembers);
	
	//RES_Point에 record만들기
	void insertResPoint();
	//RES_Point에 record삭제
	void deleteResPoint();
	//RES_Point에 record수정
	void updateResPoint();
	//RES_Point에 record가져오기
	void selectResPoint();
	
	//AGREE_RECORD에 record만들기
	void insertAgreeRecord(Map map);
	//AGREE_RECORD에 record가져오기
	AgreeRecordDTO selectAgreeRecord(Map map);
	//AGREE_RECORD에 record가져오기
	void updateAgreeRecord(Map map);
}
