package com.xingxing.privateRecord.util;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class commonResponseUtil {

	public static JSONObject responseMethod(JSONObject json, HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Method", "POST,GET");
		resp.setHeader("Cache-Control","no-cache");
		return json;
	}
}
