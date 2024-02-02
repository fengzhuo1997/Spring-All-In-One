package com.servlet.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DemoController extends HttpServlet {
	
	private String message;

	public void init() throws ServletException {
	      // 执行必需的初始化
	      message = "{\n"
	      		+ "  \"name\": \"fengzo\",\n"
	      		+ "  \"age\": 26,\n"
	      		+ "  \"hobbies\": [\"basketball\", \"football\"]\n"
	      		+ "}";
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException {

		response.setContentType("application/json");
		
		// 响应内容
		PrintWriter out = response.getWriter();
		out.println(message);
	}
	
	public void destory() {}
} 