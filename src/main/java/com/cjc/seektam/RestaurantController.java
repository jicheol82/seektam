package com.cjc.seektam;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjc.seektam.model.ResCommentDTO;
import com.cjc.seektam.model.ResPointDTO;
import com.cjc.seektam.model.RestaurantDTO;
import com.cjc.seektam.service.RestaurantService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// 이 restaurant 쪽 구현은 이것저것 test를 하느라
// parameter들이 뒤죽박죽인 것 같음(일관성이 떨어짐?)
// refactory를 통해서 정리가 필요함
@Controller
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	// ajax로 넘어온 data중에 객체의 배열로 이루어진 경우 중복 코드를 줄이기 위해 만든 메서드
	private List jsonToDTOList(String jsonData, String collectionType) {
		// 넘어오는 자료에 빈칸이 있으면 (예를들어 "distance" : "") 받아주는 객체타입에 
		// 인스턴스 필드가 private Integer distance라고 선언되어 있으면 empty String 에러가 발생됨으로
		// private String distance로 바꾸거나 없앰(distance는 이 PJ에서 사용하지 않기 때문에)
		Gson gson = new Gson();	// 수업시간엔 jackson을 썼지만 GSON이 사용하기 편해보여서/직관적이여서 이걸로 사용
		List result = null;	// 객체를 담을 배열
		Type mapListType = null;	// 잘모르겠음 객체 배열로 변환할때 사용됨
		if(collectionType.equals("RestaurantDTO")) {
			mapListType = new TypeToken<ArrayList<RestaurantDTO>>() {}.getType();
		}else if(collectionType.equals("ResCommentDTO")) {
			mapListType = new TypeToken<ArrayList<ResCommentDTO>>() {}.getType();
		}
		
		result = gson.fromJson(jsonData, mapListType);
		return result;
	}
	
	// ajax로 json이 넘어올때는 String으로 넘어오는데 얘를 spring에서 받아주려면 @Requestbody를 써야하고
	// 만약 넘어오는 그 json이 어떤 객채의 형태(DTO)라면 @ModelAttribute를 쓰면
	// 자동으로 변환하여 해당객체에 json값들을 저장해준다
	// 즉 String으로 받아서 Map으로 해주거나 객체로 받거나 하면 된다
	
	//home.js에서 ajax로 검색된 음식점의 id가 포함된 배열을 받는다
	//받은 배열을 이용하여 DB의 RESTAURANT 테이블에서	평점(POINT)을 받아온다
	//받아온 평점을 /home에 응답한다
	@ResponseBody
	@RequestMapping("/restaurant/getPoint")
	public List<Map<String, Object>> getPoint(@RequestBody String jsonData) {
		// 넘어온 json data를 list형식으로 변경
		List convertedList = jsonToDTOList(jsonData, "RestaurantDTO");
		// 음식점id를 이용하여 평점 가져오기
		List result = (List) restaurantService.getPoints(convertedList);
		//List result = new array
		// 음식점id를 이용하여 평가(comment) 가져오기
		return result;
	}
	
	
	//res_id를 이용하여 평가글 가져오기
	@ResponseBody
	@RequestMapping("/restaurant/getcomments")
	public Map getComments(@RequestBody String jsonData) {
		Gson gson = new Gson(); // 이것도 변수선언해버리는게 나을 듯, 아닌가?
		Map resIdMap = gson.fromJson(jsonData, Map.class);
		//음식점id를 이용하여 평가(comment) 가져오기
		Map result = restaurantService.getComments(resIdMap);
		return result;
	}
	
	// 평가글에 인정 불인정하기(프론트구현안됨)
	@ResponseBody
	@RequestMapping("/restaurant/agree")
	public ResCommentDTO voetToComment(@RequestBody String jsonData)  {
		Gson gson = new Gson();
		Map voteResult = gson.fromJson(jsonData, Map.class);
		ResCommentDTO result = restaurantService.voteToComment(voteResult);
		return result;
	}
	
	//식당평가글쓰기
	@ResponseBody
	@RequestMapping("/restaurant/writeComment")
	public ResCommentDTO writeComment(@ModelAttribute ResCommentDTO commentDTO, @ModelAttribute ResPointDTO pointDTO) {
		restaurantService.writeComment(commentDTO, pointDTO);
		return null;
	}
	
	//식당평가글삭제
	@ResponseBody
	@RequestMapping("/restaurant/deleteComment")
	public void deleteComment(@RequestBody String jsonData) {
		Gson gson = new Gson();
		Map deleteData = gson.fromJson(jsonData, Map.class);
		restaurantService.deleteComment(deleteData);
	}
	
	//식당추가
	@ResponseBody
	@RequestMapping("/restaurant/addrestaurant")
	public void addRestaurant(@ModelAttribute RestaurantDTO resDTO) {
		restaurantService.addRestaurant(resDTO);
	}
	
}
