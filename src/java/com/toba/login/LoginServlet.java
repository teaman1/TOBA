package com.toba.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.toba.userbean.UserBean;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("login-reset") !=null && request.getParameter("login-reset").equals("Reset Password")) {
            response.sendRedirect("password_reset.jsp");
        } else {
            UserBean user = new UserBean();
            HttpSession session = request.getSession();
            user = (UserBean) session.getAttribute("user");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                session.setAttribute("user", user);
                response.sendRedirect("Account_activity.jsp");
            } else {
                session.setAttribute("user", null);
                response.sendRedirect("Login_failure.jsp");
            }
        }
    }

}
