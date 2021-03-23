package com.cjc.seektam;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjc.seektam.dto.restaurant.RestaurantDTO;
import com.cjc.seektam.service.restaurant.RestaurantService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	public List jsonToDTOList(String jsonData) {
		// 넘어오는 자료에 빈칸이 있으면 (예를들어 "distance" : "") 받아주는 객체타입(KakadoMapDTO)에 
		// private Integer distance라고 있으면 empty String 에러가 발생됨으로
		// private String distance로 바꾸거나 없앰
		Gson gson = new Gson();
		Type mapListType = new TypeToken<ArrayList<RestaurantDTO>>() {}.getType();
		List<RestaurantDTO> result = gson.fromJson(jsonData, mapListType);
		return result;
	}
	
	//home.js에서 ajax로 검색된 음식점의 id 배열을 받는다
	//받은 배열을 이용하여 DB의 RESTAURANT 테이블에서	평점(POINT)을 받아온다
	//받아온 평점을 /home에 표시한다
	@ResponseBody
	@RequestMapping("/restaurant/getPoint")
	public Map<String, Object> getPint(@RequestBody String jsonData) {
		// 넘어온 json data를 
		List resList = jsonToDTOList(jsonData);
		// 음식점id를 이용하여 평점 가져오기
		Map<String, Object> map = restaurantService.getPoints(resList);
		// 음식점id를 이용하여 평가(comment) 가져오기
		System.out.println(map.toString());
		System.out.println(map.get("1118826861"));
		return map;
	}
	
	
}
