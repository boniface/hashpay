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
            <section id="account" data-role="page"  data-theme="b">
                <header data-role="header"><h1>Hash Pay </h1>
                    <a href="/hashpay/login/Test.html" class='ui-btn-left ui-btn-back' data-icon='arrow-l' rel='external'>Back</a>
                    <nav data-role="navbar">
                        <ul>
                            <li><a rel=external href="/hashpay/login/Test.html">Buy</a></li>
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
                            <input type="text" readonly="true" name="username" id="username" value="${username}" />
                        </div>
    
                        <h4>Personal Details</h4>
                        <div class="ui-grid-d">
                            <div class="ui-block-a"><label for="title">Title:</label></div>
                            <div class="ui-block-b"><label for="Firstname">First Name:</label></div>
                            <div class="ui-block-c"><label for="Lastname">Last Name:</label></div>
                            <div class="ui-block-d"><label for="Nickname">Nick Name:</label></div>
                            <div class="ui-block-a"><input type="text" name="Title" id="Title" value="${title}"/></div>
                            <div class="ui-block-b"><input type="text" name="Firstname" id="Firstname" value="${firstname}" /></div>
                            <div class="ui-block-c"><input type="text" name="LastName" id="LastName" value="${lastname}"/></div>
                            <div class="ui-block-d"><input type="text" name="Nickname" id="Nickname" value="${nickname}"/></div>
                       </div>
                        <h4>Contact Details</h4>
                        <div class="ui-grid-d">
                            
                         <div class="ui-block-a"><label for="HomeNumber">Home Number:</label></div>
		         <div class="ui-block-b"><label for="CellNumber">Cell Number:</label></div>
		         <div class="ui-block-c"><label for="FaxNumber">Fax Number:</label></div>
		         <div class="ui-block-d"><label for="EmailAddress">Email Address:</label></div>
                        
		         <div class="ui-block-a"><input type="text" name="HomeNumber"  id="HomeNumber"/></div>
		         <div class="ui-block-b"><input type="text" name="CellNumber" id="CellNumber" /></div>
		         <div class="ui-block-c"><input type="text" name="FaxNumber"  id="FaxNumber" /></div>
		         <div class="ui-block-d"><input type="text" name="Emailaddress" id="Emailaddress" /></div>
                    
                         
                       </div>
                        <div>
                        <h4>Home Address Details</h4>
                      
                            <div>
                        <div id="PhysicalAddressDiv" data-role="fieldcontain">
                            <label for="PostalAddress">Physical Address:</label>
                            <input type="text" name="PostalAddress"  id="PostalAddress" />
                        </div>
                        <div id="PostalAddressDiv" data-role="fieldcontain">
                            <label for="PhysicalAddress">Postal Address:</label>
                            <input type="text" name="PhysicalAddress" id="PhysicalAddress" />
                        </div>
                        <div class="ui-grid-d">
                        <div class="ui-block-a"><label for="PostalCode">Postal Code:</label></div>
                        <div class="ui-block-a"><input type="text" name="PostalCode" id="PostalCode" /></div>
                        </div>
                            </div>
                        
                        </div>
                        <div data-role="controlgroup" data-type="horizontal">
                            <input type="submit" value="Save" data-theme="b" />
                            <a href="/hashpay/login/Test.html" data-role="button" data-theme="b">back</a>
                        </div>
                        
                        
                    </form>
                </div>


                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
        </div>
    </body>
</html>
