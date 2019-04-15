package com.xingxing.privateRecord.init;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.xingxing.privateRecord.service.PersonalGoalsService;

@Component
@Order(value = 0)
public class IDQueryRunner implements CommandLineRunner{

	@Autowired
	private PersonalGoalsService personalGoalsService;
	public static int goalEndNum;
	
	@Override
	public void run(String... arg0) throws Exception {
		 String goalNum = personalGoalsService.queryGoalEndID();
		 String endString = goalNum.substring(1, goalNum.length());
		 goalEndNum = Integer.valueOf(endString);
		// System.out.println("最后的数字:"+goalEndNum);
	}

}
