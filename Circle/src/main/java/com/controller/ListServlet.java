package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ListModel;
import com.model.ListVal;

public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	ListModel list = new ListModel();	
	List<ListVal> l1 = list.listData();
	List lis = new ArrayList();
	for(ListVal val : l1) {
		List li = new ArrayList();
		li.add(val.getBookNo());
		li.add(val.getBookName());
		li.add(val.getAuthor());
		li.add(val.getLan());
		li.add(val.getPrice());
		lis.add(li);
		
	}
	System.out.println(lis);
	}

}
