package com.xxx.car.controller;

import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.car.persistence.TestMapper;

@RestController
@RequestMapping("/api")
public class UserController {

	@RequestMapping("/user/my")
	public Map<String, String> my(Authentication authentication,HttpServletRequest request){
		Enumeration<String> keys = request.getSession().getAttributeNames();
		System.out.println("keys--->" );
		System.out.println("-------------------session start--------------------");
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			System.out.println("key->" + key + "   value->" + request.getSession().getAttribute(key));
		}
		System.out.println("-------------------session start--------------------");
		Enumeration<String> requestKeys = request.getAttributeNames();
		System.out.println("------------------request start---------------------");
		while(requestKeys.hasMoreElements()){
			String key = requestKeys.nextElement();
			System.out.println("key->" + key + "   value->" + request.getAttribute(key));
		}
		System.out.println("-------------------request end--------------------");
		//authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication == null );
		if(authentication!=null){
			if(authentication instanceof AnonymousAuthenticationToken){
				AnonymousAuthenticationToken aat = (AnonymousAuthenticationToken) authentication;
				Object obj = aat.getPrincipal();
				System.out.println("obj--->" + obj);
			}
			if(authentication instanceof UsernamePasswordAuthenticationToken){
				UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken) authentication;
				System.out.println(upat.getDetails());
				
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "zhaiyuyong");
		map.put("age", "26");
		return map;
	}
	@Autowired
	private TestMapper testMapper;
	@RequestMapping("/user/you")
	public Map<String, Object> you(Principal principal){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "zhaiyuyong");
		map.put("age", "26");
		map.put("db", testMapper.test("1,2"));
		return map;
	}
}
