package com.cjc.seektam.service.restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.seektam.dao.group.GroupDAO;
import com.cjc.seektam.dao.restaurant.RestaurantDAO;
import com.cjc.seektam.dto.restaurant.RestaurantDTO;

@Service
public class RestaurantServiceImple implements RestaurantService {
	@Autowired
	private RestaurantDAO restaurantDAO;
	@Autowired
	private GroupDAO groupDAO;
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
	public List getPoints(List convertedList) {
		// 필요 객체 생성
		List idList =  extractId(convertedList); // 식당정보에서 id만 추출
		List result = new ArrayList();
		// db에 음식점id를 보내 음식점 정보가져오기
		List<RestaurantDTO> list = restaurantDAO.getRestaurant(idList);
		if(list!=null) {
			for(RestaurantDTO dto : list) {
				Map points = new HashMap();
				//음식점의 평점만 추출하여 음식점id:평점 만듦
				points.put("id", dto.getId());
				points.put("point", dto.getPoint());
				result.add(points);
			}
			return result;
		}
		// 검색 음식점의 평점이 없다면 null 반환
		return null;
	}
	@Override
	public List getComments(Map idMap) {
		// group_member에서 user_id 이용하여 가입 group찾기 : myGrList
		String userId = (String) idMap.get("user_id");
		List myGrList = groupDAO.findMyGr(userId);
		// res_comment에서 res_id의 글 중에서
		// myGrList에있는 작성자가 쓴 글과
		// open이 전체공개인 data를 가져온다 : list<RescommentDTO>
		String resId = (String) idMap.get("res_id");
		List commentList = restaurantDAO.getResComment(resId, myGrList);
		return null;
	}

	
}
