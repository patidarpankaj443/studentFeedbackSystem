package com.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.Util;

public class Teacherremove {
	public static int validate(String email)
	{
		int rs=0;
	boolean status= false;
   String sql="delete from teacher where  email=? ";
	try(Connection con=Util.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql))
    {  
			
		    stmt.setString(1,email);
			rs=stmt.executeUpdate();
	
			
		System.out.println("status "+status);
		
    }
			catch(Exception e){}
	
			
			return rs;
			
	}
	

}
