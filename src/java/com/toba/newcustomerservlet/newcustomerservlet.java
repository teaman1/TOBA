package com.toba.newcustomerservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class newcustomerservlet
 */
@WebServlet("/newcustomerservlet")
public class newcustomerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newcustomerservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmation = request.getParameter("confirmation");
		if (firstname == null || lastname == null || phone == null || address == null || city == null || state == null
				|| zip == null || email == null || password == null || confirmation == null || firstname.isEmpty()
				|| lastname.isEmpty() || phone.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty()
				|| zip.isEmpty() || email.isEmpty() || password.isEmpty() || confirmation.isEmpty()) {

			PrintWriter out = response.getWriter();
			out.print("<html><head>");
			out.print("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
			out.print("<div class=\"container\">");
			out.print("    <div class=\"row\">");
			out.print("        <div class=\"col-md-6 col-md-offset-3\">");
			out.print(
					"            <h1 class=\"text-danger text-center\">Please fill in all values.  Press the back button to fix.</h1>");
			out.print("        </div>");
			out.print("    </div>");
			out.print("</div>");
			out.print("</head><body></body></html>");
		} else {

			response.sendRedirect("Success.html");
		}

	}

}
