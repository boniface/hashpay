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
            <section id="profile" data-role="page"  data-theme="b">
                <header data-role="header"><h1>Hash Pay </h1>
                    <nav data-role="navbar">
                        <ul>
                            <li><a rel=external href="/hashpay/hashpay/login/Test.html">Buy</a></li>
                            <li><a rel=external href="/hashpay/profile/profileDetails.html" class="ui-btn-active">Profile</a></li>
                            <li><a rel=external href="/hashpay/account/accountDetails.html">Accounts</a></li> 
                        </ul>

                    </nav>
                </header>
                <div data-role="content" class="content">
                    <f:form  action="changePassword.html" id="newPassword" action="j_spring_security_check" method="post">
                        <div data-role="fieldcontain">
                            <label for="emailAddress">Old Password:</label>
                            <input type="text" name="oldPassword" id="oldPassword" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="password">New Password:</label>
                            <input type="password" name="newPassword" id="newPassword" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="retypePassword">Re Type New Password:</label>
                            <input type="password" name="retypeNewPassword" id="retypeNewPassword" />
                        </div>

                        <div data-role="controlgroup" data-type="horizontal">
                            <input type="submit" value="Save" data-theme="b" />
                        </div>
                    </f:form>
                </div>


                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
        </div>
    </body>
</html>
