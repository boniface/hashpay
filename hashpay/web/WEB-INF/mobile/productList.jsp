<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>jQuery Mobile Application</title>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
        <script src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
    </head>
    <body>
        <div data-role="header">
            <!-- begin page -->
            <section id="productList" data-role="page"  data-theme="b">
                <header data-role="header"><h1>Hash Pay </h1>
                    <a href="/hashpay/login/Test.html" class='ui-btn-left ui-btn-back' data-icon='arrow-l' rel='external'>Back</a>
                    <nav data-role="navbar">
                        <ul>
                            <li><a rel=external href="/hashpay/hashpay/login/Test.html" class="ui-btn-active">Buy</a></li>
                            <li><a rel=external href="/hashpay/profile/profileDetails.html">Profile</a></li>
                            <li><a rel=external href="/hashpay/account/accountDetails.html">Accounts</a></li> 
                        </ul>

                    </nav>
                </header>
                <div data-role="content" class="content">
                    <ul data-role="listview" data-theme="g">
                        <c:forEach items="${list}" var="product">
                            <li><a rel=external href="/hashpay/product/buyProduct.html?id=${product.id}"><c:out value="Description:${product.description} ${product.productSerialNumber} ${product.currencySymbol}${product.unitPrice}"/>
                        </c:forEach>
                    </ul>
                </div>
                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
        </div>
    </body>
</html>
