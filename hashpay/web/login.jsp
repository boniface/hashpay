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
            <h1>Swatch E Header</h1>
            <!-- begin first page -->
            <section id="page1" data-role="page"  data-theme="b">

                <header data-role="header"><h1>Welcome HashPay </h1>
                </header>
                <div data-role="content" class="content">

                    <form id="myform" action="j_spring_security_check" method="post">
                        <div data-role="fieldcontain">
                            <label for="email-address">Email Address:</label>
                            <input type="text" name="j_username" id="email-address" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="password">Password:</label>
                            <input type="password" name="j_password" id="password" />
                        </div>
                        <div data-role="controlgroup" data-type="horizontal">
                            <a href="index.html" data-role="button" data-theme="b">Forgot Password</a>
                            <input type="submit" value="Login" data-theme="b" />
                            <input type="reset" value="Reset" data-theme="b"/>
                        </div>

                    </form>


                    <p><a href="#page2" data-rel="dialog">Register</a></p>
                </div>
                <footer data-role="footer"><h1>Hash Pay</h1></footer>
            </section>
            <!-- end first page -->
            <!-- Begin second page -->
            <section id="page2" data-role="page" data-theme="b">
                <header data-role="header" data-theme="b"><h1>Register HashPay Account</h1></header>
                <div data-role="content" class="content" data-theme="b">

                    <form id="myform" action="formprocessor.php" method="post">
                        <div data-role="fieldcontain">
                            <label for="email-address">Email Address:</label>
                            <input type="text" name="email-address" id="email-address" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="password">Password:</label>
                            <input type="password" name="password" id="password" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="retype-password">Re Type Password:</label>
                            <input type="password" name="Retype" id="retype-password" />
                        </div>

                        <div data-role="controlgroup" data-type="horizontal">
                            <input type="submit" value="Register" data-theme="b" />
                            <a href="index.html" data-role="button" data-theme="b">Login</a>
                            <input type="reset" value="Reset" data-theme="b"/>
                        </div>

                    </form>
                </div>
                <footer data-role="footer"r data-theme="b"><h1>Hash Pay Footer</h1></footer>
            </section>
            <!-- end second page -->
        </div>
    </body>
</html>
