<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Activity</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>

    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">

                    <div class="navbar-brand">TODA</div>
                </div>
                <div class="collapse navbar-collapse navbarCollapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="Login.jsp">Login</a></li>
                        <li><a href="New_Customer.jsp">Register</a> </li>
                        <li><a href="Transaction.jsp">Transaction</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <c:if test="${user != null}">
                        <h1 class="text-info text-center">You are logged in as ${user.firstName} ${user.lastName}</h1>
                    </c:if>
                    <c:if test="${user == null}">
                        <h1 class="text-danger text-">You are not logged in.</h1>
                    </c:if>

                </div>
            </div>
        </div>
        <script src="js/jquery-3.2.0.min.js"></script>
        <script src="js/bootstrap.js"></script>
    </body>
</html>