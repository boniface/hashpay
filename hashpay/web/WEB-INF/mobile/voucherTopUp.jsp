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
            <h1>Voucher Top-Up</h1>
            <a href="/hashpay/hashpay/login/Test.html" class='ui-btn-left ui-btn-back' data-icon='arrow-l' rel='external'>Back</a>
            <section id="page2" data-role="page" data-theme="b">
                <header data-role="header" data-theme="b"><h1>HashPay Voucher Top-Up</h1></header>
                <div data-role="content" class="content" data-theme="b">

                    <f:form  method="POST" modelAttribute="user" action="voucherTopUp.html">
                        <div data-role="fieldcontain">
                            <label for="vouchernumber">Insert voucher number:</label>
                            <input type="text" name="vouchernumber" id="vouchernumber" />

                        <div data-role="controlgroup" data-type="horizontal">
                            <input type="submit" value="Top-Up" data-theme="b" />
                            <a href="/hashpay/login/Test.html" data-role="button" data-theme="b">back</a>
                        </div>
                           
                    </f:form>
                </div>
                <footer data-role="footer"r data-theme="b"><h1>Hash Pay Footer</h1></footer>
            </section>
            <!-- end second page -->
        </div>
    </body>
</html>
