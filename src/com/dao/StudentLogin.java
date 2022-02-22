package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import Database.Util;

public class StudentLogin {
	public static boolean login(String regino,String password)
	{
		boolean status=false;
		String sql="select * from student where  regino=? and password=?";
		try(Connection con=(Connection) Util.getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql))
		{
			pstmt.setString(1,regino);
		    pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			status=rs.next();
			System.out.println("status "+status);
		}
		catch(Exception ex) {}
		return status;

	}
}
