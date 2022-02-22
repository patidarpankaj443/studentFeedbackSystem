package com.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dao.Studentdao;
import com.dto.Student;

/**
 * Servlet implementation class Studentcontroller
 */
public class Studentcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studentcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getRequestURI().equals("./delete")) {
			
			
		}
		try {
			System.out.println("hello");
			Studentdao st=new Studentdao();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String name=request.getParameter("name");
			String regino = request.getParameter("regino"); 
			String password = request.getParameter("password");
			Student s=new Student(name,regino,password);
			s.setName(name);
			s.setRegino(regino);
			s.setPassword(password);
			boolean b=st.add(name,regino, password);
			 
			System.out.print(name+" "+regino+" "+password);
			if(b)
			{
			RequestDispatcher rd = request
						.getRequestDispatcher("addstudent.jsp");
				rd.include(request, response);
			}
			else
			{
				out.println("<h3><b>Student already exist<b/></h3>");
			}
		}
		catch(Exception ex) {}
	}
	
}
