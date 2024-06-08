package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CircleDao{
	public List<Pojo> FetchDivision(String circleNo) {
	    List<Pojo> div = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        String query = "jdbc:mysql://localhost:3306/servlet?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String pwd = "root";
	        String sql = "SELECT DIVCD, DIVNAME FROM excel WHERE CIRCD=? GROUP BY DIVCD, DIVNAME ORDER BY DIVNAME";
	        
	        Class.forName("com.mysql.cj.jdbc.Driver"); // Corrected driver class
	        
	        con = DriverManager.getConnection(query, user, pwd);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, circleNo); // Set the parameter value
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            Pojo p = new Pojo();
	            p.setDivisionCD(rs.getString(1)); 
	            p.setDivisionName(rs.getString(2));
	            div.add(p);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	    return div;
	}

}
