package com.xingxing.privateRecord.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xingxing.privateRecord.Application;

@RestController
@RequestMapping("/api/personalGoals")
public class PersonalGoalsController {

	private static Logger log= Logger.getLogger(Application.class);
	
	@RequestMapping("/login")
	public String login(){
		return "success";
	}
	
	
}
