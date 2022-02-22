package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dto.Admin;

import Database.Util;
public class AdminDao {

	public static boolean validate(String uname,String password)
	{
	boolean status= false;
   String sql="select * from admin where uname=? and password=?";
   Admin ad=new Admin(uname,password);
	try(Connection con=Util.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql))
    {  
			stmt.setString(1,ad.getUname());
		    stmt.setString(2,ad.getPassword());
			ResultSet rs=stmt.executeQuery();
			status=rs.next();
			System.out.println("status "+status);

    }
			catch(Exception e){}
	
			return status;
	}
}
			

