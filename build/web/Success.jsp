<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   <meta charset="UTF-8">
   <title>Success</title>
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
         <h1 class="text-info text-center">Thank you.</h1>
      </div>
      <div class="row">
      <div class="col-lg-12 text-center">
         <div class="form-group">
            <h4>Here is your information:</h4>
         </div>
         <div class="form-group">           
            <label>First Name:</label>
            <span>${user.firstName}</span>
         </div>
         <div class="form-group">           
            <label>Last Name:</label>
            <span>${user.lastName}</span>
         </div>
         <div class="form-group">           
            <label>Phone:</label>
            <span>${user.phone}</span>
         </div>
         <div class="form-group">           
            <label>Address:</label>
            <span>${user.address}</span>
         </div>
         <div class="form-group">           
            <label>City:</label>
            <span>${user.city}</span>
         </div>
         <div class="form-group">           
            <label>State:</label>
            <span>${user.state}</span>
         </div>
         <div class="form-group">           
            <label>Zip Code:</label>
            <span>${user.zipcode}</span>
         </div>
         <div class="form-group">           
            <label>Email:</label>
            <span>${user.email}</span>
         </div>
         <div class="form-group">           
            <label>Username:</label>
            <span>${user.username}</span>
         </div>
         <div class="form-group">
            <label>Password:</label>
            <span>${user.password}</span>
         </div>
      </div>
   </body>
</html>