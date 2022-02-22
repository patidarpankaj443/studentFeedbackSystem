package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import Database.Util;

public class TeacherLogin {
public static boolean login(String email,String password)
{
	boolean status=false;
	String sql="select * from teacher where  email=? and password=?";
	try(Connection con=(Connection) Util.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql))
	{
		pstmt.setString(1,email);
	    pstmt.setString(2,password);
		ResultSet rs=pstmt.executeQuery();
		status=rs.next();
		System.out.println("status "+status);
	}
	catch(Exception ex) {}
	return status;

}
}
