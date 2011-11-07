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
            <!-- begin first page -->
            <section id="accountEntries" data-role="page"  data-theme="b">
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
                    <ul data-role="listview" data-theme="g">
                        <c:forEach items="${accountList}" var="num">
                            <li><a href="#"><c:out value="${balance}"/>
                                                     <c:out value="${debit}"/>
                                                     <c:out value="${credit}"/>
                                                     <c:out value="${description}"/>
                                </a></li>
                        </c:forEach>#
                    </ul>
                </div>


                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
        </div>
    </body>
</html>
