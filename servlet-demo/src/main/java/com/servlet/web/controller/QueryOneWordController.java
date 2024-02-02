package com.servlet.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.servlet.web.dto.Word;
import com.servlet.web.service.WordService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class QueryOneWordController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("application/json");
		
	    String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		WordService ws = new WordService();
		try {
			Word word = ws.queryOne(id);
			Gson gson = new Gson();
			String res = gson.toJson(word);
			PrintWriter out = response.getWriter();
			out.println(res);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void destory() {}
} 