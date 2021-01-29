package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.userService;
@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	@Qualifier("userService")
	private userService userService;
	public ModelAndView listAllUsers() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("users",userService.listAllUsers());
		return mav;
	}
	public void clear() {
		
		
	}
	public Object getSocket() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("users",userService.listAllUsers());
		return mav;
			}
	
}
