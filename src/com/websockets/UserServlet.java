package com.websockets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RequestDispatcher rd;
	@Override
    public void init() throws ServletException {
        System.out.println("init");
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		System.out.println("doget");
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();

		HttpSession session=request.getSession(true);
		String username=request.getParameter("username");
		session.setAttribute("username",username);
		System.out.println(username);
		if(username!=null && username.equals("doctor"))
		{
			System.out.print("asdfghjkl");
			rd=request.getRequestDispatcher("/doctor.jsp");
			rd.forward(request,response);
		}
		else if(username!=null && username.equals("ambulance"))
		{
			rd=request.getRequestDispatcher("/ambulance.jsp");
			rd.forward(request, response);
		}
		else if(username!=null)
		{
			rd=request.getRequestDispatcher("/patient.jsp");
			rd.forward(request, response);
		}
	}
}