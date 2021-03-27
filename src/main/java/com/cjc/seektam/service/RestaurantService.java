package com.cjc.seektam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cjc.seektam.model.ResCommentDTO;
import com.cjc.seektam.model.ResPointDTO;
import com.cjc.seektam.model.RestaurantDTO;

public interface RestaurantService {
	
	public List getPoints(List convertedList);
	public List getComments(Map resId);
	public ResCommentDTO voteToComment(Map voteResult);
	public void writeComment(ResCommentDTO commentDTO, ResPointDTO pointDTO);
}
