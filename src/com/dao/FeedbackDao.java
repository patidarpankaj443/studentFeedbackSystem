package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Database.Util;

public class FeedbackDao {
	String status="";
	public  int add(String email,String rate,String rate1,String rate2,String rate3,String rate4,String rate5,String rate6,
			String rate7,String rate8,String rate9)
	{
		int i=0; 
   String sql="insert into feedback values(?,?,?,?,?,?,?,?,?,?,?)";
	try(Connection con=Util.getConnection();
	Statement st=con.createStatement();
	PreparedStatement pstmt=con.prepareStatement(sql))
	{
			pstmt.setString(1,email);
		    pstmt.setString(2,rate);
		    pstmt.setString(3,rate1);
		    pstmt.setString(4,rate2);
		    pstmt.setString(5,rate3);
		    pstmt.setString(6,rate4);
		    pstmt.setString(7,rate5);
		    pstmt.setString(8,rate6);
		    pstmt.setString(9,rate7);
		    pstmt.setString(10,rate8);
		    pstmt.setString(11,rate9);
		    ResultSet rs=st.executeQuery("(select * from feedback where faculty_email='"+email+"')");
		    boolean b=rs.next();
		    System.out.println(b);
		    if(b==true)
		    {
		    	System.out.println(b);
		    	System.out.println("fail");
		    }
		    else
		    {
					i=pstmt.executeUpdate();
					status=" Success";
					System.out.println("success");
		    }
			
		    
    }
			catch(Exception e){}
	
			return i;
			
	}
}
