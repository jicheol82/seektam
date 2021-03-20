package com.cjc.seektam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {
	@RequestMapping("/restaurant")
	public String restaurant() {
		return "restaurant/restaurant";
	}
}
