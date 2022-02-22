package com.dao;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import Database.Util;

public class ChangeStudentPassword {
	public static int update(String regino,String password)
	{
		int rs=0;
		String sql="update student set password=? where regino=?";
		try(Connection con=(Connection) Util.getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql))
		{
			pstmt.setString(1,password);
		    pstmt.setString(2,regino);
			 rs=pstmt.executeUpdate();
			
			System.out.println("status "+rs);
		}
		catch(Exception ex) {}
		return rs;

	}
}
