package com.toba.resetpassword;

import com.toba.data.UserDB;
import com.toba.entities.User;
import static com.toba.password.PasswordUtil.PasswordEncoder.getEncryptedPassword;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public ResetPassword() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("Login_mustbe.jsp");
        } else {
            String oldpassword = "";
            try {
                oldpassword = getEncryptedPassword(request.getParameter("oldpassword"));
                String userpass = user.getPassword();
                if (!oldpassword.equals(userpass)) {
                    response.sendRedirect("passwordmustmatch.jsp");
                    return;
                }
            } catch (Exception ex) {
                throw ex;
            }
            String newpassword = "";
            
            try {
                newpassword = getEncryptedPassword(request.getParameter("newpassword"));
            } catch (Exception ex) {
                throw ex;
            }
            if (newpassword != "") {
                    user.setPassword(newpassword);
                    user = UserDB.update(user);
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("Success.jsp");
            }
        }
    }
    
}
