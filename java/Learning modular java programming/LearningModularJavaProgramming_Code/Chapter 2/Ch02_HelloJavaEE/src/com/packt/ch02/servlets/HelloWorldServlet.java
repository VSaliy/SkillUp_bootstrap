package com.packt.ch02.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorldServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//read the request parameter
		String name=request.getParameter("name");
		//get the writer
		PrintWriter writer=response.getWriter();
		
		//set the MIME type
		response.setContentType("text/html");
		
		//generate the output in form of HTML
		/*
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Hello "+name+" from JAVA Enterprise");
		writer.println("</body>");
		writer.println("</html>");
		*/
		
		request.setAttribute("message","Welcome "+name+" From JAVA Enterprise");
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsps/hello.jsp");
		dispatcher.forward(request, response);
		
	}

}

