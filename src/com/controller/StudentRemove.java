package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RemoveStudent;
import com.dao.Teacherremove;

/**
 * Servlet implementation class StudentRemove
 */
public class StudentRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRemove() {
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
			out.println("student");
			RemoveStudent tr=new RemoveStudent();
			String regino=request.getParameter("regino");
		
			
			int isSuccess=tr.validate(regino);
			out.println(regino);
			if (isSuccess>0) {
				out.println("<b>Successfully removed</b>");
				RequestDispatcher rd = request
						.getRequestDispatcher("removestudent.jsp");
				rd.include(request, response);
			} else {
				out.println("<b>does not exist</b>");
				RequestDispatcher rd = request
						.getRequestDispatcher("removestudent.jsp");
				rd.include(request, response);
			}
		}
			catch(Exception e){}
	
	}
	}

