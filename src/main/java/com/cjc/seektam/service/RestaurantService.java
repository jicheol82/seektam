package com.cjc.seektam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cjc.seektam.model.ResCommentDTO;
import com.cjc.seektam.model.ResPointDTO;
import com.cjc.seektam.model.RestaurantDTO;

public interface RestaurantService {
	// 식당정보를 이용하여 db에 있는 평점 가져오기
	public List getPoints(List convertedList);
	// 식당 id로 평가글 가져오기
	public Map getComments(Map resId);
	// 
	public ResCommentDTO voteToComment(Map voteResult);
	public void writeComment(ResCommentDTO commentDTO, ResPointDTO pointDTO);
	public void deleteComment(Map deleteData);
	public void addRestaurant(RestaurantDTO resDTO);
}
