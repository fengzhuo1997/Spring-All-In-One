package com.servlet.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.servlet.web.dto.Word;
import com.servlet.web.service.WordService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class QueryAllWordController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("application/json");
		
		WordService ws = new WordService();
		try {
			ArrayList<Word> words = ws.queryAll();
			Gson gson = new Gson();
			String res = gson.toJson(words);
			PrintWriter out = response.getWriter();
			out.println(res);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void destory() {}
} 