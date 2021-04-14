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
	//CRUD에 맞춰 db별로 미리 만듦
	//사용안하는 메소드도 있음 mapper와 비교 필요
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
	List selectResComment0(@Param("resId")Double resId); //숫자가커서 Double로 선언했던것 같음 그러면 @Param없이 sql이 작동안했던듯
	List selectResComment1(@Param("resId")Double resId, @Param("myGrMembers") List myGrMembers); //맵퍼로 바꾼이유! 두개의 parameter를 Map으로 변경하지 않고 쓰기 위해서
	
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
