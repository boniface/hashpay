<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>


<html>
    <head>
        <title>Hash Pay Mobile App</title>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
        <script src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
    </head>
    <body>
        <div data-role="header">
            <h1>Create Account </h1>
            <section id="page2" data-role="page" data-theme="b">
                <header data-role="header" data-theme="b"><h1>Register HashPay Account</h1></header>
                <div data-role="content" class="content" data-theme="b">

                    <f:form  method="POST" modelAttribute="user" action="newaccount.html">
                        <div data-role="fieldcontain">
                            <label for="emailAddress">Email Address:</label>
                            <input type="text" name="emailAddress" id="emailAddress" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="password">Password:</label>
                            <input type="password" name="password" id="password" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="retypePassword">Re Type Password:</label>
                            <input type="password" name="retypePassword" id="retypePassword" />
                        </div>

                        <div data-role="controlgroup" data-type="horizontal">
                            <input type="submit" value="Register" data-theme="b" />
                            <a href="/index.jsp" data-role="button" data-theme="b">Login</a>
                            <input type="reset" value="Reset" data-theme="b"/>
                        </div>

                    </f:form>
                </div>
                <footer data-role="footer"r data-theme="b"><h1>Hash Pay Footer</h1></footer>
            </section>
            <!-- end second page -->
        </div>
    </body>
</html>
