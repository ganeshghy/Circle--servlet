package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DivisionDao {
	public List<Pojo> FetchEro(String divNo) {
	    List<Pojo> eroName = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        String query = "jdbc:mysql://localhost:3306/servlet?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String pwd = "root";
	        String sql = "SELECT EROCD, ERONAME FROM excel WHERE DIVCD=? GROUP BY EROCD, ERONAME ORDER BY ERONAME";
	        
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        
	        con = DriverManager.getConnection(query, user, pwd);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, divNo); 
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            Pojo p = new Pojo();
	            p.setEroCD(rs.getString(1));
	            p.setEroName(rs.getString(2));
	            eroName.add(p);
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
	    return eroName;
	}

}
