<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <title>Transaction</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>

    <body>
        <c:import url="header.html" />
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                   
                       
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="register-form" action="transaction" method="post" role="form" style="display: block;">
                                        <div class="row">
                                        <div class="form-group">
                                            <p>Savings balanse: ${savings.balance}</p>
                                        </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                   <p>Checking balanse: ${checking.balance}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:import url="footer.jsp" />
    </body>
</html>