package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.Util;

public class RemoveStudent {
	public static int validate(String regino)
	{
		int rs=0;
	boolean status= false;
   String sql="delete from student where  regino=? ";
	try(Connection con=Util.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql))
    {  
			
		    stmt.setString(1,regino);
			rs=stmt.executeUpdate();
	
			
		System.out.println("status "+status);
		
    }
			catch(Exception e){}
	
			
			return rs;
			
	}
		

}
