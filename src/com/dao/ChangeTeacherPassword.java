package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import Database.Util;

public class ChangeTeacherPassword {
	public static int update(String email,String password)
	{
		int rs=0;
		String sql="update teacher set password=? where email=?";
		try(Connection con=(Connection) Util.getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql))
		{
			pstmt.setString(1,password);
		    pstmt.setString(2,email);
			 rs=pstmt.executeUpdate();
			
			System.out.println("status "+rs);
		}
		catch(Exception ex) {}
		return rs;

	}
}
