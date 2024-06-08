package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.model.AjaxCircleDao;
import com.model.Pojo;

public class AjaxCircleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	AjaxCircleDao circle = new AjaxCircleDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int[] arr = {2,3,7,8,5};
		List<Pojo> cir = circle.FetchCircle(arr);
		Map<String, String> circleMap = new HashMap<>();
		
		for (Pojo circle : cir) {
            circleMap.put(circle.getCircleCD(), circle.getCircleName());
        }
		 Gson gson = new Gson();
	     String json = gson.toJson(circleMap);
//	     System.out.println(json);
	     request.setAttribute("json",json);
	     RequestDispatcher rd = request.getRequestDispatcher("Cricle.jsp");
	     rd.forward(request, response);
	}

}
