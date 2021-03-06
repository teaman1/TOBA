<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Must be logged in</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>

    <body>
        <c:import url="header.html" />
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h1 class="text-danger text-center">Must be logged in.</h1>
                </div>
            </div>
        </div>
        <c:import url="footer.jsp" />
    </body>
</html>