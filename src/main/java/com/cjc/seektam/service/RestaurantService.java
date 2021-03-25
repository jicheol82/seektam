package com.cjc.seektam.service;

import java.util.List;
import java.util.Map;

import com.cjc.seektam.model.RestaurantDTO;

public interface RestaurantService {
	
	public List getPoints(List convertedList);
	public List getComments(Map resId);
}
