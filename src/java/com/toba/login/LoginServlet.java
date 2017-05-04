package com.toba.login;

import com.toba.data.UserDB;
import com.toba.entities.User;
import com.toba.password.PasswordUtil.PasswordEncoder;
import static com.toba.password.PasswordUtil.PasswordEncoder.getEncryptedPassword;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.toba.userbean.UserBean;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        try {
                user = UserDB.GetUser(username);
        } catch (Exception ex) {
            
             response.sendRedirect("Login_failure.jsp");
             return;
        }
        String hashedPwd = getEncryptedPassword(password);
        if (user != null && username.equals(user.getUserName()) && hashedPwd.equals(user.getPassword())) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("Account_activity.jsp");
        } else {
            request.getSession().setAttribute("user", null);
            response.sendRedirect("Login_failure.jsp");
        }
    }

}
