<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Reset Password</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>

    <body>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="New_Customer.html" class="active" id="login-form-link">Register Instead</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="login-form" action="ResetPassword" method="post" role="form" style="display: block;">
                                        <div class="form-group">
                                            <input type="text" name="oldpassword" id="oldpassword" tabindex="1" class="form-control" placeholder="Old Password" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="newpassword" id="newpassword" tabindex="2" class="form-control" placeholder="New Password">
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="resetpw-submit" id="resetpw-submit" tabindex="4" class="form-control btn btn-login" value="Change Password">
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
        <script src="js/jquery-3.2.0.min.js"></script>
        <c:import url="footer.jsp" />
    </body>
</html>