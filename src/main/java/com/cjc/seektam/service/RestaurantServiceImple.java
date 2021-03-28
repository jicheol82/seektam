package com.cjc.seektam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.seektam.mapper.GroupDAO;
import com.cjc.seektam.mapper.MemberDAO;
import com.cjc.seektam.mapper.RestaurantDAO;
import com.cjc.seektam.model.AgreeRecordDTO;
import com.cjc.seektam.model.MemberDTO;
import com.cjc.seektam.model.ResCommentDTO;
import com.cjc.seektam.model.ResPointDTO;
import com.cjc.seektam.model.RestaurantDTO;


@Service
public class RestaurantServiceImple implements RestaurantService {
	@Autowired
	private RestaurantDAO restaurantDAO;
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberDAO memberDAO;
	
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
		List<RestaurantDTO> list = restaurantDAO.selectRestaurant(idList);
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
	public Map getComments(Map resIdMap) {
		// Session에서 memId 가져오기
		//String userId = memberService.getMemId();
		// 테스트를 위해서 임으로 넣음
		String userId = "admin";
		// resId의 값 가져오기
		Double resId =(Double)resIdMap.get("id");
		// memId로 Group_member에서 가입 그룹 list 가져오기
		List myGrList = groupDAO.findMyGr(userId);
		// 가입그룹의 회원 가져오기
		List myGrMembers = groupDAO.findGrMember(myGrList);
		// res_comment에서 writer가 myGrMembers이고 그룹공개(1) 또는
		// 전체공개(0) 글 가져온다
		// 넘어온 내용 확인-getResComment0은 전체공개 글 모두 불러오고, getResComment1은 나와 같은 그룹원의 글중 그룹공개 글만 가져옴
		List commentList = restaurantDAO.selectResComment0(resId);
		commentList.addAll(restaurantDAO.selectResComment1(resId, myGrMembers));
		
		// 가져온 평가글의 평가점수 가져오기
		if(!commentList.isEmpty()) {
			List refList = new ArrayList();
			for(int i=0; i<commentList.size(); i++) {
				ResCommentDTO dto = (ResCommentDTO) commentList.get(i);
				refList.add(dto.getNum());
			}
			List pointList = restaurantDAO.selectResPoint(refList);
			//평가글의 인정율에 따라 순서 바꾸기
			Map result = new HashMap();
			result.put("comment", commentList);
			result.put("point", pointList);
			return result;
		}
		return null;
	}
	@Override
	public ResCommentDTO voteToComment(Map voteResult)  {
		System.out.println("service in");
		// Map에 사용자id 추가
		String memId = memberService.getMemId();
			System.out.println("memId 생성 : "+memId);
		voteResult.put("memId", memId);
		// member 테이블에서 사용자의 평점 가중치 가져와 map에 추가
		MemberDTO dto = memberDAO.selectMember(memId);
		float weight = dto.getReputation();
		voteResult.put("weight", weight);
			System.out.println("사용자의 가중치 : "+weight);
		// 이전에 평가한 적이 있는지 확인
		AgreeRecordDTO agreeDTO = restaurantDAO.selectAgreeRecord(voteResult);
			System.out.println("평가글 이력이 없어? "+(agreeDTO.getId()).isEmpty());
		if((agreeDTO.getId()).isEmpty()) {
			//평가한적이 있으면 아무것도 하지 않음.
			//평가한적이 없으면
			// res_comment 테이블에 가중치 반영하여 평가글 인정/불인정 점수 높이기
			restaurantDAO.updateResComment(voteResult);
			// agree_record 테이블에 평가 기록하기(평가 이력이 없으면 insert/있으면 update)
			restaurantDAO.insertAgreeRecord(voteResult);
		}
		return null;
	}
	//식당평가글쓰기+점수주기
	@Override
	public void writeComment(ResCommentDTO commentDTO, ResPointDTO pointDTO) {
		//글 등록
		restaurantDAO.insertResComment(commentDTO, pointDTO);
		//등록된 글 가져오기(점수도)
	}
	//수정은 안만듦
	//식당평가글 삭제
	@Override
	public void deleteComment(Map deleteData) {
		String memId = memberService.getMemId();
		if(deleteData.get("writer").equals(memId)) {
			restaurantDAO.deleteResComment(deleteData);
		}
			
		
	}
	

	
}
