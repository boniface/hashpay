<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <li><a rel=external href="/hashpay/hashpay/login/Test.html">Buy</a></li>
                            <li><a rel=external href="/hashpay/profile/profileDetails.html" class="ui-btn-active">Profile</a></li>
                            <li><a rel=external href="/hashpay/account/accountDetails.html">Accounts</a></li> 
                        </ul>

                    </nav>
                </header>
                <div data-role="content" class="content">
                    <form method="POST" modelAttribute="user" action="updateProfile.html">
                        <h4>PROFILE DETAILS</h4>
                        <div data-role="fieldcontain">
                            <label for="username">Username:</label>
                            <input type="text" readonly="true" name="j_name" value="${username}" id="Username" />
                        </div>
    
                        <h4>Personal Details</h4>
                        <div class="ui-grid-d">
                            <div class="ui-block-a"><label for="title">Title:</label></div>
                            <div class="ui-block-b"><label for="Firstname">First Name:</label></div>
                            <div class="ui-block-c"><label for="Lastname">Last Name:</label></div>
                            <div class="ui-block-d"><label for="Nickname">Nick Name:</label></div>
                            <div class="ui-block-a"><input type="text" name="j_title" value="${title}" id="Title" /></div>
                            <div class="ui-block-b"><input type="text" name="j_fname" value="${firstname}" id="Firstname"  /></div>
                            <div class="ui-block-c"><input type="text" name="j_lname" value="${lastname}" id="LastName" /></div>
                            <div class="ui-block-d"><input type="text" name="j_nickname" value="${nickname}" id="Nickname" /></div>
                       </div>
                        <h4>Contact Details</h4>
                        <c:forEach items="${contactList}" var="contact">
                        <div class="ui-grid-d">
                         <div class="ui-block-a"><label for="HomeNumber">Home Number:</label></div>
		         <div class="ui-block-b"><label for="CellNumber">Cell Number:</label></div>
		         <div class="ui-block-c"><label for="FaxNumber">Fax Number:</label></div>
		         <div class="ui-block-d"><label for="EmailAddress">Email Address:</label></div>
		         <div class="ui-block-a"><input type="text" name="j_homeNumber" value="${contact.phoneNumber}" id="HomeNumber"/></div>
		         <div class="ui-block-b"><input type="text" name="j_cellNumber" value="${contact.cellNumber}" id="CellNumber" /></div>
		         <div class="ui-block-c"><input type="text" name="j_faxNumber" value="${contact.cellNumber}" id="FaxNumber" /></div>
		         <div class="ui-block-d"><input type="text" name="j_email" value="${contact.emailAddress}"id="Emailaddress" /></div>
                       </div>
                         </c:forEach>
                        
                        <div data-role="controlgroup" data-type="horizontal">
                            <input type="submit" value="Save" data-theme="b" />
                        </div>
                        
                        
                    </form>
                </div>


                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
        </div>
    </body>
</html>
