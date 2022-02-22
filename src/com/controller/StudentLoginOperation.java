package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentLogin;
import com.dao.TeacherLogin;

/**
 * Servlet implementation class StudentLoginOperation
 */
public class StudentLoginOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StudentLogin tl = new StudentLogin();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String regino = request.getParameter("regino");
			String password = request.getParameter("password");
			
			System.out.println(regino+":"+password);
			if (tl.login(regino, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("username", regino);
				session.setMaxInactiveInterval(120);
				RequestDispatcher rd = request
						.getRequestDispatcher("studentoption.jsp");
				rd.include(request, response);
			} else {
				out.println("<b>Registration no or password is invalid</b>");
				RequestDispatcher rd = request
						.getRequestDispatcher("studentlogin.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
