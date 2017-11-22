package irsDbase.control;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import irsDbase.model.*;

/*
 * First servlet in the Control package
 * Processes entered login credentials
 * http://localhost:8080/IrsDbase/
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Where to send response
		RequestDispatcher dispatcher;
		
		// Checks authentication of textbox fields entered in login.jsp
		Access access = new Access(request.getParameter("user"), request.getParameter("pass"));

		if (access.granted) {
			// Populate collection Model with all user accounts 
			Records records = new Records();
			
			// Send logged in user's name and accounts to display View
			dispatcher = request.getRequestDispatcher("WEB-INF/display.jsp");
			request.setAttribute("fullName", access.fullName);
			request.setAttribute("accounts", records.accounts);
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
