package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListModel {
	
	public List<ListVal> listData() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ListVal> l2 = new ArrayList<>();
		try {
			
			String query = "jdbc:mysql://localhost:3306/servlet";
	        String user = "root";
	        String pwd = "root";
	        String sql = "select * from booking";
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(query,user,pwd);
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	ListVal l1 = new ListVal();
	        	l1.setBookNo(rs.getString(1));
	        	l1.setBookName(rs.getString(2));
	        	l1.setAuthor(rs.getString(3));
	        	l1.setLan(rs.getString(4));
	        	l1.setPrice(rs.getString(5));
	        	l2.add(l1);
	        	}
		}catch(Exception e) {
			e.printStackTrace();
			}
	
		return l2;
		
	}
}
