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
import com.model.EroDao;
import com.model.Pojo;

public class EroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	EroDao ero = new EroDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eroNo = request.getParameter("eroNo");
		List<Pojo> subName = ero.FetchSub(eroNo);
		Map<String, String> subMap = new HashMap<>();
		for (Pojo sub : subName) { 
			  subMap.put(sub.getSubCD(),sub.getSubName()); 
		  } 
		 Gson gson = new Gson();
		 String json = gson.toJson(subMap);
//		 System.out.println(json);
		 response.setContentType("application/json");
		 PrintWriter out = response.getWriter();
		 out.print(json);
		 out.flush();
	}

}
