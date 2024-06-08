package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.model.Pojo;
import com.model.SubDao;


public class SubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubDao sub = new SubDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subNo = request.getParameter("subNo");
		List<Pojo> secName = sub.FetchSection(subNo);
		
		Map<String, String> secMap = new HashMap<>();
		for (Pojo sec : secName) { 
			  secMap.put(sec.getSecCD(),sec.getSecName()); 
		  } 
		Gson gson = new Gson();
		String json = gson.toJson(secMap);
//		System.out.println(json);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		
	}
}
