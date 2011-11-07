<!DOCTYPE html>
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
                            <li><a href="/home.jsp">Buy</a></li>
                            <li><a href="#">Profile</a></li>
                            <li><a href="#" class="ui-btn-active">Accounts</a></li> 
                        </ul>

                    </nav>
                </header>
                <div data-role="content" class="content">
                    <form id="accountForm" action="j_spring_security_check" method="post">
                        <div data-role="fieldcontain">
                            <label for="email-address">Account Number:</label>
                            <input type="text" name="j_accountNumber" id="accountNumber" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="email-address">Current Balance:</label>
                            <input type="text" name="j_currentBalance" id="currentBalance" />
                        </div>                        
                    </form>
                    <a href="#" data-role="button">Account Transactions</a>
                </div>


                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
        </div>
    </body>
</html>
