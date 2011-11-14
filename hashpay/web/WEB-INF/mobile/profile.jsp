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
            <section id="profile" data-role="page"  data-theme="b">
                <header data-role="header"><h1>Hash Pay </h1>
                    <nav data-role="navbar">
                        <ul>
                            <li><a href="/home.jsp">Buy</a></li>
                            <li><a href="#" class="ui-btn-active">Profile</a></li>
                            <li><a href="#">Accounts</a></li> 
                        </ul>

                    </nav>
                </header>
                <div data-role="content" class="content">
                    <form id="profileForm" method="post" >
                        <div data-role="fieldcontain">
                            <label for="username">Username:</label>
                            <input type="text" name="j_name" id="Username" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="name">Name:</label>
                            <input type="text" name="j_name" id="Name" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="surname">Surname:</label>
                            <input type="text" name="j_name" id="Surname" />
                        </div>
                        <div data-role="controlgroup" data-type="horizontal">
                            <input type="submit" value="Save" data-theme="b" />
                        </div>
                        <a href="#" data-role="button">Forgot Password</a>
                    </form>
                </div>


                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
        </div>
    </body>
</html>
