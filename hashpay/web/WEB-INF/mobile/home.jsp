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
            <section id="page1" data-role="page"  data-theme="b" >
                <header data-role="header"><h1>Hash Pay </h1>
                    
                    <nav data-role="navbar">
                        <ul>
                            <li><a href="#" class="ui-btn-active">Buy</a></li>
                            <li><a rel=external href="/hashpay/profile/profileDetails.html">Profile</a></li>
                            <li><a rel=external href="/hashpay/account/accountDetails.html">Accounts</a></li> 
                        </ul>

                    </nav>
                </header>
                <div data-role="content" class="content">
                        <a href="/hashpay/home/Newhome.html" data-role="button" data-theme="b">Logout</a>
                    <h4 align="center">Available Products</h4>
                    <ul data-role="listview">
                        <li data-role="Divider"></li>
                        <li> Tickets
                          <ul>
                                <li><a href="/hashpay/product/productList.html?id=Bus-Ticket">Bus Tickets</a></li>
                                </ul>
                        </li>
                            <li data-role="Divider"></li>
                            <li> Air-Time 
                                <ul>
                                    <li><a href="/hashpay/product/productList.html?id=Air-time">TopUp Air-Time</a></li>
                                </ul>
                                
                             </li>
                             <li data-role="Divider"></li>
                             <li>Electricity
                                 <ul>
                                     <li><a href="/hashpay/product/productList.html?id=Eletricity">Eletricity</a></li>
                                 </ul>
                             </li>
                             <li data-role="Divider"></li>
                             <li>Voucher
                                 <ul>
                                     <li><a href="/hashpay/product/voucherList.html?id=INVENTORY">Select voucher</a></li>
                                 </ul>
                             </li>
                             <a rel=external href="/hashpay/product/voucher.html" data-role="button">Top-Up Voucher</a>
                       
                    
                  <!--  <a href="#" data-role="button">Airtime</a>
                    <a href="#" data-role="button">Movie Tickets</a>
                    <a href="#" data-role="button">Electricity</a> --!>
                        <!--
        <p>First page!</p>

                    <h3>Buttons</h3>
                    <a href="#" data-role="button">Link-based button</a>
                    <input type="submit" value="submit" data-inline="true">
                    <input type="reset" value="reset" data-inline="true">
                    <h3>Checkboxes and Radio Buttons</h3>
                    <form id="myform" action="formprocessor.php" method="post">
                        <div data-role="fieldcontain">
                            <label for="slider-music">Ambient Music</label>
                            <select name="slider-music" id="slider-music" data-role="slider">
                                <option value="on">On</option>
                                <option value="off">Off</option>
                            </select>
                            <div data-role="fieldcontain">
                                <label for="search-restaurants">Search Restaurants:</label>
                                <input type="search" name="search-restaurants" id="search-restaurants" />
                            </div>

                        </div>
                    </form>


                    <p><a href="#page2" data-rel="dialog">HashPay Diaolog</a></p>-->
                </div>
                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
            <!-- end first page -->
            <!-- Begin second page -->
            <!--<section id="page2" data-role="page" data-theme="b">
                <header data-role="header" data-theme="b"><h1>HashPay Mobile</h1></header>
                <div data-role="content" class="content" data-theme="b">
                    <p>Second page!</p>
                </div>
                <footer data-role="footer"r data-theme="b"><h1>Hash Pay Footer</h1></footer>
            </section>-->
            <!-- end second page -->
        </div>
    </body>
</html>
