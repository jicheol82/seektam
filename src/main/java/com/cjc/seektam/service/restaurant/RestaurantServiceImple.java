package com.cjc.seektam.service.restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.seektam.dao.restaurant.RestaurantDAO;
import com.cjc.seektam.dto.restaurant.RestaurantDTO;

@Service
public class RestaurantServiceImple implements RestaurantService {
	@Autowired
	private RestaurantDAO restaurantDAO;
	
	// 클라이언트에서 받아온 식당정보에서 식당id만 추출
	public List extractId(List resList) {
		List result = new ArrayList();
		for(int i=0;i<resList.size();i++) {
			RestaurantDTO dto = (RestaurantDTO) resList.get(i);
			result.add(dto.getId());
		}
		return result;
	}
	@Override
	public Map getPoints(List resList) {
		// 필요 객체 생성
		List idList =  extractId(resList); // 식당정보에서 id만 추출
		Map points = new HashMap();
		// db에 음식점id를 보내 음식점 정보가져오기
		List<RestaurantDTO> list = restaurantDAO.getRestaurant(idList);
		if(list!=null) {
			for(RestaurantDTO dto : list) {
				//음식점의 평점만 추출하여 음식점id:평점 만듦
				points.put(dto.getId(), dto.getPoint());
				System.out.println("dto.getId()"+dto.getId());
				System.out.println("dto.getPoint()"+dto.getPoint());
				return points;
			}
		}
		// 검색 음식점의 평점이 없다면 null 반환
		return null;
	}

}
