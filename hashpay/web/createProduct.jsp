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
            <h1>Create Product </h1>
            <section id="page2" data-role="page" data-theme="b">
                <header data-role="header" data-theme="b"><h1>New Product Details</h1></header>
                <div data-role="content" class="content" data-theme="b">

                    <f:form  method="POST" modelAttribute="product" action="createproduct.html">
                        <div data-role="fieldcontain">
                            <label for="serialNumber">Serial Number:</label>              
                                <input type="text" name="serialNumber" id="serialNumber" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="description">Description:</label>
                            <input type="description" name="description" id="description" />
                        </div>
                        <div data-role="fieldcontain">
                            <label for="unitPrice">Unit Price:</label>
                            <input type="unitPrice" name="unitPrice" id="unitPrice" />
                        </div>
                        
                        <div data-role="fieldcontain">
                            <label for="status">Status:</label>
                            <input type="status" name="status" id="status" />
                        </div
                        
                        
                       <div data-role="fieldcontain">
                            <label for="type">Type:</label>
                            <input type="type" name="type" id="type" />
                        </div>
                        
                        <div data-role="fieldcontain">
                            <label for="currency">Currency:</label>
                            <input type="currency" name="currency" id="currency" />
                        </div>
                                                                                       
                        <div data-role="controlgroup" data-type="horizontal">
                            <input type="submit" value="Send" data-theme="b" />
                            <input type="reset" value="Reset" data-theme="b"/>
                      </div>

                    </f:form>
                </div>
                <footer data-role="footer"r data-theme="b"><h1>Hash Pay Footer</h1></footer>
            </section>
            <!-- end second page -->
        </div>
    </body>