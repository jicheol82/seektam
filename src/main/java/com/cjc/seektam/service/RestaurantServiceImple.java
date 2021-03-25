package com.cjc.seektam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.seektam.mapper.GroupDAO;
import com.cjc.seektam.mapper.RestaurantDAO;
import com.cjc.seektam.model.ResCommentDTO;
import com.cjc.seektam.model.RestaurantDTO;


@Service
public class RestaurantServiceImple implements RestaurantService {
	@Autowired
	private RestaurantDAO restaurantDAO;
	@Autowired
	private GroupDAO groupDAO;
	private MemberService memberService;
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
	public List getComments(Map resIdMap) {
		// Session에서 memId 가져오기
		//String userId = memberService.getMemId();
		// 테스트를 위해서 임으로 넣음
		String userId = "admin";
		// resId의 값 가져오기
		String resId =(String)resIdMap.get("id");
		System.out.println("resId"+resId);
		// memId로 Group_member에서 가입 그룹 list 가져오기
		List myGrList = groupDAO.findMyGr(userId);
		System.out.println("myGrList"+myGrList.get(0).toString());
		// 가입그룹의 회원 가져오기
		List myGrMembers = groupDAO.findGrMember(myGrList);
		// res_comment에서 writer가 myGrMembers이고 그룹공개(1) 또는
		// 전체공개(0) 글 가져온다
		//넘어온 내용 확인
		//List commentList = restaurantDAO.getResComment(resId, myGrMembers);
		List<ResCommentDTO> commentList = restaurantDAO.getResComment(resId, myGrMembers);
		for(ResCommentDTO dto : commentList) {
			System.out.println(dto.getComments());
		}
		return commentList;
	}

	
}
