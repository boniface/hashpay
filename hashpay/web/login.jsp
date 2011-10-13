<!DOCTYPE html>
<html>
    <head>
        <title>Hash Pay Mobile App</title>
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


                    <p><a href="register/createaccount.html?new" >Create Account</a></p>
                </div>
                <footer data-role="footer"><h1>Hash Pay</h1></footer>
            </section>
        </div>
    </body>
</html>
