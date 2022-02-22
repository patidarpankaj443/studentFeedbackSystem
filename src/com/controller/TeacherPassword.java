package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ChangeTeacherPassword;
import com.dao.Teacherremove;

/**
 * Servlet implementation class TeacherPassword
 */
public class TeacherPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("teacher");
		ChangeTeacherPassword tr=new ChangeTeacherPassword();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
	
		
		int isSuccess=tr.update(email,password);
		out.println(email);
		if (isSuccess>0) {
			out.println("<b>Successfully updated</b>");
			RequestDispatcher rd = request
					.getRequestDispatcher("teacherlogin.jsp");
			rd.include(request, response);
		} else {
			out.println("<b>Password not Updated</b>");
			RequestDispatcher rd = request
					.getRequestDispatcher("changeteacherpassword.jsp");
			rd.include(request, response);
		}
	}
	}


