package com.xxx.car.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/web")
public class WebController {

	
	@RequestMapping("/test")
	public Map<String, String> admin(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("name", "sw");
		return result;
	}
}
