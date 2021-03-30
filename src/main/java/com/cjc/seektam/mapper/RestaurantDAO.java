package com.cjc.seektam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cjc.seektam.model.AgreeRecordDTO;
import com.cjc.seektam.model.ResCommentDTO;
import com.cjc.seektam.model.ResPointDTO;
import com.cjc.seektam.model.RestaurantDTO;

@Mapper
public interface RestaurantDAO {
	//CRUD
	//RESTAURANT에 record만들기
	void insertRestaurant(RestaurantDTO resDTO);
	//RESTAURANT에 record삭제
	void deleteRestaurant();
	//RESTAURANT에 record수정
	void updateRestaurant();
	//RESTAURANT에 record가져오기
	List selectRestaurant(List idList);
	
	//RES_COMMENT에 record만들기
	void insertResComment(@Param("comment") ResCommentDTO commentDTO, @Param("point") ResPointDTO pointDTO);
	//RES_COMMENT에 record삭제
	void deleteResComment(Map deleteData);
	//RES_COMMENT에 record수정
	void updateResComment(Map map);
	//RES_COMMENT에 record가져오기
	List selectResComment0(@Param("resId")Double resId);
	List selectResComment1(@Param("resId")Double resId, @Param("myGrMembers") List myGrMembers);
	
	//RES_Point에 record만들기-comment 생성시 같이 생성됨
	void insertResPoint();
	//RES_Point에 record삭제-comment 삭제시 같이 삭제됨
	void deleteResPoint();
	//RES_Point에 record수정-미사용
	void updateResPoint();
	//RES_Point에 record가져오기
	List selectResPoint(List refList);
	
	//AGREE_RECORD에 record만들기
	void insertAgreeRecord(Map map);
	//AGREE_RECORD에 record가져오기
	AgreeRecordDTO selectAgreeRecord(Map map);

}
