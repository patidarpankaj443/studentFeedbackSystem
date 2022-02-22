package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ChangeStudentPassword;
import com.dao.ChangeTeacherPassword;

/**
 * Servlet implementation class StudentPassword
 */
public class StudentPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPassword() {
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
		ChangeStudentPassword st=new ChangeStudentPassword();
		String regino=request.getParameter("regino");
		String password=request.getParameter("password");
	
		
		int isSuccess=st.update(regino,password);
		out.println(regino);
		if (isSuccess>0) {
			out.println("<b>Successfully updated</b>");
			RequestDispatcher rd = request
					.getRequestDispatcher("studentlogin.jsp");
			rd.include(request, response);
		} else {
			out.println("<b>Password not updated</b>");
			RequestDispatcher rd = request
					.getRequestDispatcher("changestudentpassword.jsp");
			rd.include(request, response);
		}
	}

}
