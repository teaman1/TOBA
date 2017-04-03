<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Must be logged in</title>
    <meta charset="UTF-8">
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
                <li><a href="New_Customer.jsp">Register</a></li>
                <li><a href="Transaction.jsp">Transaction</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="text-danger text-center">Must be logged in.</h1>
        </div>
    </div>
</div>

</body>
</html>