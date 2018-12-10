package com.xingxing.privateRecord.util;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIDUtil {

	private static AtomicInteger count = new AtomicInteger();
	
	public static String getQualityNum(String s, int end) {
		count.set(end);
		count.incrementAndGet();
		Integer i = count.get();
		String strNum = null;
		if(String.valueOf(i).length() == 1) {
			strNum = String.format("%s%s", "0000", i);
		}else if(String.valueOf(i).length() == 2) {
			strNum = String.format("%s%s", "000", i);
		}else if(String.valueOf(i).length() == 3) {
			strNum = String.format("%s%s", "00", i);
		}else if(String.valueOf(i).length() == 4) {
			strNum = String.format("%s%s", "0", i);
		}else if(String.valueOf(i).length() == 5) {
			strNum = String.format("%s", i);
		}
		
		return String.format("%s%s", s,strNum);
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(AtomicIDUtil.getQualityNum("G", 20000));
	}

}
