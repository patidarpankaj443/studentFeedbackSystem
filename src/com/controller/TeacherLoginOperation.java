package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TeacherLogin;
import com.dto.Teacher;

/**
 * Servlet implementation class TeacherLoginOperation
 */
public class TeacherLoginOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLoginOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			TeacherLogin tl = new TeacherLogin();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email+":"+password);
			if (tl.login(email, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("username", email);
				session.setMaxInactiveInterval(120);
				RequestDispatcher rd = request
						.getRequestDispatcher("teacheroption.jsp");
				rd.include(request, response);
			} else {
				out.println("<center><h3><b>Email or password is invalid</b></h3></center>");
				RequestDispatcher rd = request
						.getRequestDispatcher("teacherlogin.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
