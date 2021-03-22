package com.cjc.seektam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cjc.seektam.service.restaurant.RestaurantService;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	//home.js에서 ajax로 검색된 음식점의 id 배열을 받는다
	//받은 배열을 이용하여 DB의 RESTAURANT 테이블에서	평점(POINT)을 받아온다
	//받아온 평점을 /home에 표시한다
	@RequestMapping("/restaurant/getReputation")
	public Map<String, Object> getReputation(ArrayList<String> resIdList) {
		// 응답할 객체 생성
		Map<String, Object> map = null;
		// service에 연결
		
		
		return map;
	}
}
