package com.toba.newcustomerservlet;

import com.toba.data.AccountDB;
import com.toba.data.UserDB;
import com.toba.entities.Account;
import com.toba.entities.User;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import static com.toba.password.PasswordUtil.PasswordEncoder.getEncryptedPassword;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/newcustomerservlet")
public class newcustomerservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public newcustomerservlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String stateCode = request.getParameter("stateCode");
        String zipCode = request.getParameter("zipCode");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");
        if (firstname == null || lastname == null || phone == null || address == null || city == null || stateCode == null
                || zipCode == null || email == null || firstname.isEmpty()
                || lastname.isEmpty() || phone.isEmpty() || address.isEmpty() || city.isEmpty() || stateCode.isEmpty()
                || zipCode.isEmpty() || email.isEmpty()) {

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
            User user = null;
            String username = lastname + zipCode;
            //    public User(Long userId, String firstName, String lastName, String phone, String address, String city, String stateCode, String zipCode, String userName, String password, String email) {

            user = new User(0L, firstname, lastname, phone, address, city, stateCode, zipCode, username, password, email);
            if (UserDB.UserExists(email)) {
                response.sendRedirect("New_Customer.jsp");
                return;
            }

            String hashedPassword = "";

            try {

                hashedPassword = getEncryptedPassword("welcome1");
                System.out.println("Password is : " + hashedPassword);

            } catch (Exception ex) {
                throw ex;
            }

            user.setPassword(hashedPassword);
            try {
                user = UserDB.insert(user);

                Account savings = new Account(0L, 25.00, Account.AccountType.SAVINGS, user);
                savings = AccountDB.insert(savings);

                Account checking = new Account(0L, 0.00, Account.AccountType.CHECKING, user);
                checking = AccountDB.insert(checking);

                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("Success.jsp");
            } catch (Exception e) {
                throw e;
            }

        }

    }

}
