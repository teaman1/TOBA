package com.toba.resetpassword;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.toba.userbean.UserBean;
import javax.servlet.http.HttpSession;
import com.toba.data.UserDB;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
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
        UserBean user = new UserBean();

        HttpSession session = request.getSession();
        user = (UserBean) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("Login_mustbe.jsp");
        } else {
            String oldpassword = request.getParameter("oldpassword");
            String newpassword = request.getParameter("newpassword");
            if (user.getPassword().equals(oldpassword)) {
                user.setPassword(newpassword);            
                UserDB.update(user);
                response.sendRedirect("Success.jsp");
                
            }
        }
    }
}
