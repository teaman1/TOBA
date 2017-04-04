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
        <c:import url="header.html" />
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
        <c:import url="footer.jsp" />

    </body>
</html>