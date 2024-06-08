package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.model.CircleDao;
import com.model.Pojo;

/**
 * Servlet implementation class CircleServlet
 */
public class CircleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	CircleDao circle = new CircleDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String circleNo = request.getParameter("circleNo");
		
		
		List<Pojo> division = circle.FetchDivision(circleNo);
		
		/*
		 * for(Pojo div : division) { System.out.println(div.getDivisionCD());
		 * System.out.println(div.getDivisionName()); }
		 */
		  Map<String, String> divisionMap = new HashMap<>();
		  
		  for (Pojo div : division) { 
			  divisionMap.put(div.getDivisionCD(), div.getDivisionName()); 
		  } 
		  Gson gson = new Gson();
		  String json = gson.toJson(divisionMap);
//		  System.out.println(json);
		  response.setContentType("application/json");
		  PrintWriter out = response.getWriter();
		  out.print(json);
		  out.flush();
	}
}
