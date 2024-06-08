package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AjaxCircleDao {
	public List<Pojo> FetchCircle(int[] arr) {
		
	    List<Pojo> circle = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        String query = "jdbc:mysql://localhost:3306/servlet?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String pwd = "root";
	        
	        String sql = "SELECT CIRCD, CIRNAME FROM excel WHERE CIRCD IN (?, ?, ?, ?, ?) GROUP BY CIRCD, CIRNAME ORDER BY CIRNAME";
	        
	        Class.forName("com.mysql.cj.jdbc.Driver"); // Corrected driver class
	        
	        con = DriverManager.getConnection(query, user, pwd);
	        pstmt = con.prepareStatement(sql);
	        for (int i = 0; i < arr.length; i++) {
	            pstmt.setInt(i + 1, arr[i]); 
	        }
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            Pojo cir = new Pojo();
	            cir.setCircleCD(rs.getString(1));; 
	            cir.setCircleName(rs.getString(2));
	            circle.add(cir);
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
	    return circle;
	}

}
