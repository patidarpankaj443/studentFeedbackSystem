package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.dto.Teacher;

import Database.Util;


public class TeacherDao {
	static String status="";
	ArrayList<Teacher> al=new ArrayList<Teacher>();
	public static String add(String name,String email,String password,String branch)
	{
		String sql="insert into teacher(name,email,password,branch) values(?,?,?,?)";
		Teacher t=new Teacher(name,email,password,branch);
	
		try(Connection con=Util.getConnection();
				Statement st=con.createStatement();
				PreparedStatement pstmt=con.prepareStatement(sql)){
			pstmt.setString(1,t.getName());
		    pstmt.setString(2,t.getEmail());
		    pstmt.setString(3,t.getPassword());
		    pstmt.setString(4,t.getBranch());
			ResultSet rs=st.executeQuery("(select * from teacher where email='"+t.getEmail()+"')");
			
			boolean b=rs.next();
			if(b==true){
				status="Teacher already exists";
				}else{
					pstmt.executeUpdate();
					status=" SuccessFully added";
			}
			}
			catch(Exception e){
				e.printStackTrace();
				}
			
			return status;
	}
}
