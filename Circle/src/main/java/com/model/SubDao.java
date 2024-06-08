package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubDao {
	public List<Pojo> FetchSection(String subNo) {
	    List<Pojo> secName = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        String query = "jdbc:mysql://localhost:3306/servlet?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String pwd = "root";
	        String sql = "SELECT SECCD, SECNAME FROM excel WHERE SUBCD=? GROUP BY SECCD, SECNAME ORDER BY SECNAME";
	        
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        
	        con = DriverManager.getConnection(query, user, pwd);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, subNo); 
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            Pojo p = new Pojo();
	            p.setSecCD(rs.getString(1));
	            p.setSecName(rs.getString(2));
	            secName.add(p);
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
	    return secName;
	}
}
