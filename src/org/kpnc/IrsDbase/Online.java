package org.kpnc.IrsDbase;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Online")
public class Online extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		drawTop(response);

		PrintWriter out = response.getWriter();

		switch (request.getParameter("op")) {
			case "Login":
				Login login = new Login(
					request.getParameter("user"),
					request.getParameter("pass"));

				if (login.isAuthorized) {
					out.format("Hello, %s!", login.fullName);
				}
				else
				{
					out.println("Wrong!");
				}
				break;
			default:
				out.println("Input error");
		}
		
		drawBottom(response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		drawTop(response);
		response.getWriter().println("User error");
		drawBottom(response);
    }

	void drawTop(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.getWriter().println(
			"<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n" +
			"<html><head><title>IRS Database</title></head>" +
			"<body>");
	}
	
	void drawBottom(HttpServletResponse response) throws IOException {
		response.getWriter().println("</body></html>");
	}
}
