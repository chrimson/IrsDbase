package irsDbase.control;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/*
 * First servlet in the Control package
 * Processes entered login credentials
 * http://localhost:8080/IrsDbase/
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String TITLE = "IRS Database";	
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Where to send response
		RequestDispatcher dispatcher;
		
		// Checks authentication of textbox fields entered in login.jsp
		Access access = new Access(request.getParameter("username"), request.getParameter("password"));

		if (access.granted) {
			// Populate collection helper class with all database accounts 
			AccountServices service = new AccountServices();
			
			// Send logged in user's name and accounts to display View
			dispatcher = request.getRequestDispatcher("WEB-INF/display.jsp");
			request.setAttribute("fullName", access.fullName);
			request.setAttribute("accounts", service.accounts);
		}
		else
		{
			dispatcher = request.getRequestDispatcher("wrong.jsp");
		}
		
		// Actually process RequestDispatcher
		dispatcher.forward(request, response);
	}

	// Web app only responds meaningfully to POST
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		dispatcher.forward(request, response);
	}
}
