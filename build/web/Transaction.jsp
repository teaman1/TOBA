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
                <div class="col-md-12 col-md-offset-3">
                    <h1>Transfer Funds</h1>
                    <p>Please enter in the amount of funds to transfer.</p>
                 <form action="TransactionServlet" method="post">
                        <input type="hidden" name="action" value="transferFunds">
                        <div class="form-group">
                            <!--<p>Checking:  ${request.getSession("user").getCheckingBalance()}</p>-->
                            <p>Savings:  ${user.CheckingBalance}</p>

                            <div class="form-group form-inline">
                                Transfer from:
                                <select name="transferFrom" class="form-control">
                                    <option value="checking">Checking</option>
                                    <option value="savings">Savings</option>
                                </select>
                                Transfer to:
                                <select name="transferTo" class="form-control">
                                    <option value="checking">Checking</option>
                                    <option value="savings">Savings</option>
                                </select>
                                <label class="sr-only" for="transferAmount">Amount (in dollars)</label>
                                <div class="input-group">
                                    <div class="input-group-addon">$</div>
                                    <input type="text" class="form-control" name="transferAmount" placeholder="Amount">
                                    <div class="input-group-addon">.00</div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Transfer cash</button><br><br>
                            </form>
                        </div>
                </div>
            </div>
        </div>

<c:import url="footer.jsp" />
</body>
</html>