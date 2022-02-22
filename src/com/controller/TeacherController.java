package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TeacherDao;
import com.dto.Teacher;

/**
 * Servlet implementation class TeacherController
 */
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String branch=request.getParameter("branch");
			Teacher t=new Teacher(name,email,password,branch);
			t.setName(name);
			t.setPassword(email);
			t.setEmail(password);
			t.setBranch(branch);
			String status=TeacherDao.add(name,email,password,branch);
			out.println("<h3><b> "+status+"</b></h3>");
			System.out.println(name+" "+email+" "+password+" "+branch);
			RequestDispatcher rd=request.getRequestDispatcher("addteacher.jsp");
		     rd.include(request,response);
		}
			catch(Exception e){}
		}
	}


