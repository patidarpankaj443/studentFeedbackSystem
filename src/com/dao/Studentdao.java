package com.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.Student;

import Database.Util;

public class Studentdao
{
	
	String status= "";
	public  boolean add(String name,String regino,String password)
	{
   String sql="insert into student values(?,?,?)";
   Student st=new Student(name,regino,password);
	try(Connection con=Util.getConnection();
	Statement s=con.createStatement();
	PreparedStatement pstmt=con.prepareStatement(sql))
	{
			pstmt.setString(1,st.getName());
			pstmt.setString(2,st.getRegino());
		    pstmt.setString(3,st.getPassword());
		    ResultSet rs=s.executeQuery("(select * from student where regino='"+st.getRegino()+"')");
			boolean b=rs.next();
			System.out.println(st.getName()+" "+st.getRegino()+" "+st.getPassword());
			if(b==true){
				return false;
				}else{
					pstmt.executeUpdate();
					return true;
			}
			
    }
			catch(Exception e){}
	
			return false;

}
}