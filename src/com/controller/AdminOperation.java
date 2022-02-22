package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.dto.Admin;

/**
 * Servlet implementation class AdminOperation
 */
public class AdminOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AdminDao admindao = new AdminDao();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String uname=null;
			String password=null;
			
					uname = request.getParameter("uname");
				    password = request.getParameter("password");	
				
			Admin ad=new Admin(uname,password);
			ad.setUname(uname);
			ad.setPassword(password);

			System.out.println(uname+":"+password);
			if (admindao.validate(uname, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("username", uname);
				session.setMaxInactiveInterval(120);
				if(session==null)
				{
					RequestDispatcher rd = request
							.getRequestDispatcher("adminlogin.jsp");
					rd.include(request, response);
				}
				RequestDispatcher rd = request
						.getRequestDispatcher("adminoption.jsp");
				rd.include(request, response);
			} else {
				out.println("<b>username or password is invalid</b>");
				RequestDispatcher rd = request
						.getRequestDispatcher("adminlogin.jsp");
				rd.include(request, response);
			}

		} 

	}


