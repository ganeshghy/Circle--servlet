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
import com.model.DivisionDao;
import com.model.Pojo;

public class DivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DivisionDao division = new DivisionDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String divNo = request.getParameter("divNo");
		
		List<Pojo> eroName = division.FetchEro(divNo);
		Map<String, String> eroMap = new HashMap<>();
		for (Pojo ero : eroName) { 
			  eroMap.put(ero.getEroCD(), ero.getEroName()); 
		  } 
		 Gson gson = new Gson();
		 String json = gson.toJson(eroMap);
//		 System.out.println(json);
		 response.setContentType("application/json");
		 PrintWriter out = response.getWriter();
		 out.print(json);
		 out.flush();
	}
}
