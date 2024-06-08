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
import com.model.CircleDao;
import com.model.DivisionDao;
import com.model.EroDao;
import com.model.Pojo;
import com.model.SubDao;

/**
 * Servlet implementation class CommonServlet
 */
public class CommonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cd = request.getParameter("cd");
		int len = cd.length();
		if(len == 1) {
			
			CircleDao circle = new CircleDao();
			List<Pojo> division = circle.FetchDivision(cd);
			Map<String, String> divisionMap = new HashMap<>();
			  
			  for (Pojo div : division) { 
				  divisionMap.put(div.getDivisionCD(), div.getDivisionName()); 
			  } 
			  Gson gson = new Gson();
			  String json = gson.toJson(divisionMap);
//			  System.out.println(json);
			  response.setContentType("application/json");
			  PrintWriter out = response.getWriter();
			  out.print(json);
			  out.flush();
		}
		else if(len == 2) {
			DivisionDao division = new DivisionDao();
			List<Pojo> eroName = division.FetchEro(cd);
			Map<String, String> eroMap = new HashMap<>();
			for (Pojo ero : eroName) { 
				  eroMap.put(ero.getEroCD(), ero.getEroName()); 
			  } 
			 Gson gson = new Gson();
			 String json = gson.toJson(eroMap);
//			 System.out.println(json);
			 response.setContentType("application/json");
			 PrintWriter out = response.getWriter();
			 out.print(json);
			 out.flush();
		}
		else if(len == 3) {
			EroDao ero = new EroDao();
			List<Pojo> subName = ero.FetchSub(cd);
			Map<String, String> subMap = new HashMap<>();
			for (Pojo sub : subName) { 
				  subMap.put(sub.getSubCD(),sub.getSubName()); 
			  } 
			 Gson gson = new Gson();
			 String json = gson.toJson(subMap);
//			 System.out.println(json);
			 response.setContentType("application/json");
			 PrintWriter out = response.getWriter();
			 out.print(json);
			 out.flush();
		}
		else if(len == 4) {
			SubDao sub = new SubDao();

			List<Pojo> secName = sub.FetchSection(cd);
			
			Map<String, String> secMap = new HashMap<>();
			for (Pojo sec : secName) { 
				  secMap.put(sec.getSecCD(),sec.getSecName()); 
			  } 
			Gson gson = new Gson();
			String json = gson.toJson(secMap);
//			System.out.println(json);
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		}
	}

}
