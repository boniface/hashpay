<!DOCTYPE html>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>jQuery Mobile Application</title>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
        <script src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
    </head>
    <body>
        <div data-role="header">
            <!-- begin first page -->
            <section id="account" data-role="page"  data-theme="b">
                <header data-role="header"><h1>Hash Pay </h1>
                    <nav data-role="navbar">
                        <ul>
                            <li><a rel=external href="/hashpay/login/Test.html">Buy</a></li>
                            <li><a rel=external href="/hashpay/profile/profileDetails.html">Profile</a></li>
                            <li><a rel=external href="/hashpay/account/accountDetails.html" class="ui-btn-active">Accounts</a></li> 
                        </ul>

                    </nav>
                </header>
                <div data-role="content" class="content">
                    <f:form id="accountForm" method="post">
                        <div data-role="fieldcontain">
                            <label for="account-number">Account Number:</label>
                            <input type="text" name="j_accountNumber" id="accountNumber" readonly="true" value="${accountNumber}"/>
                        </div>
                        <div data-role="fieldcontain">
                            <label for="Status">Status:</label>
                            <input type="text" name="j_status" id="status" readonly="true" value="${status}"/>
                        </div> 
                        <div data-role="fieldcontain">
                            <label for="current-Balance">Current Balance:</label>
                            <input type="text" name="j_currentBalance" id="currentBalance" readonly="true" value="${currentBalance}"/>
                        </div>
                        <div data-role="fieldcontain">
                            <label for="currency-type">Currency:</label>
                            <input type="text" name="j_currency" id="currency" readonly="true" value="${currency}" />
                        </div>  
                    </f:form>
                    <a href="/hashpay/account/accountTransactions.html" data-role="button">Account Transactions</a>
                </div>


                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
        </div>
    </body>
</html>
