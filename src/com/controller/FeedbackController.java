package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FeedbackDao;

/**
 * Servlet implementation class FeedbackController
 */
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String rate=request.getParameter("rate");
		String rate1=request.getParameter("rate1");
		String rate2=request.getParameter("rate2");
		String rate3=request.getParameter("rate3");
		String rate4=request.getParameter("rate4");
		String rate5=request.getParameter("rate5");
		String rate6=request.getParameter("rate6");
		String rate7=request.getParameter("rate7");
		String rate8=request.getParameter("rate8");
		String rate9=request.getParameter("rate9");
		FeedbackDao fd=new FeedbackDao();
		int i=fd.add(email,rate,rate1,rate2,rate3,rate4,rate5,rate6,rate7,rate8,rate9);
		if(i>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("facultylist.jsp");
			rd.include(request, response);
			out.println("<h3><b>Feedback Submited SuccessFully</b></h3>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("feedback.jsp");
			rd.include(request, response);
			out.println("<h3><b>Invalid Email or Feedback Already given </b></h3>");
		}
	}

}
