package com.cjc.seektam;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjc.seektam.model.GroupsDTO;
import com.cjc.seektam.service.GroupService;
import com.google.gson.Gson;

@Controller
public class GroupController {
	@Autowired
	private GroupService groupService;
	
	@RequestMapping("/group")
	public String group(Model model) {
		Map groupMap = groupService.group();
		model.addAttribute("groupMap", groupMap);
		return "/group";
	}
	@ResponseBody
	@RequestMapping("/group/search")
	public List search(@RequestBody String jsonData) {
		Gson gson = new Gson();
		Map searchMap = gson.fromJson(jsonData, Map.class);
		List result = groupService.search(searchMap);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/group/makemygr")
	public int makeMyGr(@RequestBody String jsonData) {
		Gson gson = new Gson();
		GroupsDTO groupsDTO = gson.fromJson(jsonData, GroupsDTO.class);
		System.out.println(groupsDTO.getName());
		System.out.println(groupsDTO.getOpen());
		int result = groupService.createMyGr(groupsDTO);
		return result;
	}

}
