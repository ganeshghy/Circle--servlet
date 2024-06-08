package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EroDao {
	public List<Pojo> FetchSub(String eroNo) {
	    List<Pojo> subName = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        String query = "jdbc:mysql://localhost:3306/servlet?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String pwd = "root";
	        String sql = "SELECT SUBCD, SUBNAME FROM excel WHERE EROCD=? GROUP BY SUBCD, SUBNAME ORDER BY SUBNAME";
	        
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        
	        con = DriverManager.getConnection(query, user, pwd);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, eroNo); 
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            Pojo p = new Pojo();
	            p.setSubCD(rs.getString(1));
	            p.setSubName(rs.getString(2));
	            subName.add(p);
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
	    return subName;
	}
}
