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
            <h1>Swatch E Header</h1>
            <!-- begin first page -->
            <section id="page1" data-role="page"  data-theme="b">

                <header data-role="header"><h1>Hash Pay </h1>
                </header>
                <div data-role="content" class="content">

                   <f:form  method="POST" modelAttribute="usr" action="forgotpassword.html">
                        <div data-role="fieldcontain">
                            <label for="emailAddress">Email Address:</label>
                            <input type="text" name="emailAddress" id="emailAddress" />
                        </div>

                        <div data-role="controlgroup" data-type="horizontal">
                            <input type="submit" value="Send" data-theme="b" />
                        </div>

                    </f:form>
                </div>
                <footer data-role="footer"><h1>Hash Pay</h1></footer>
            </section>
        </div>
    </body>
</html>
