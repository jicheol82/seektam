package com.cjc.seektam;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjc.seektam.service.GroupService;

@Controller
public class GroupController {
	@Autowired
	private GroupService groupService;
	
	@RequestMapping("/group")
	public Map group() {
		Map groupMap = groupService.group();
		return groupMap;
	}

}
