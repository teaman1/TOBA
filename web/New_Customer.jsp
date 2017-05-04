<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.toba.data.UserDB" %>

<html lang="en">
    <head>
        <title>Register</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>

    <body>
        <c:import url="header.html" />
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="Login.jsp"id="login-form-link">Login Instead</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="register-form" action="newcustomerservlet" method="post" role="form" style="display: block;">
                                
                                        <div class="form-group">
                                            <h2 class="text-danger"><c:out default="" value="${UserDB.geterrorMessage()}"></c:out></h2>                                        
                                        </div>    

                                        <div class="form-group">
                                            <input type="text" name="firstname" id="firstname" tabindex="1" class="form-control" placeholder="First Name" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="lastname" id="lastname" tabindex="1" class="form-control" placeholder="Last Name" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="phone" id="phone" tabindex="1" class="form-control" placeholder="Phone" value="">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" name="address" id="address" tabindex="1" class="form-control" placeholder="Address" value="">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" name="city" id="city" tabindex="1" class="form-control" placeholder="City" value="">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" name="stateCode" id="stateCode" tabindex="1" class="form-control" placeholder="State" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="zipCode" id="zipCode" tabindex="1" class="form-control" placeholder="Zip" value="">
                                        </div>

                                        <div class="form-group">
                                            <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
                                        </div>
                                        <!--                                <div class="form-group">
                                                                            <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <input type="password" name="confirmation" id="confirmation" tabindex="2" class="form-control" placeholder="Confirm Password">
                                                                        </div>-->
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
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