package com.cjc.seektam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjc.seektam.dto.restaurant.KakaoMapDTO;
import com.cjc.seektam.service.restaurant.RestaurantService;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/restaurant")
	public String restaurant(String locPosition, Model model) {
		if(locPosition != null) {
			List<KakaoMapDTO> list = restaurantService.getRestaurantList(locPosition);
			model.addAttribute("restaurantList", list);
		}
		return "restaurant/restaurant";
	}
}
