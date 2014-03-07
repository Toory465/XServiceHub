<%-- 
    Document   : userAddESDL
    Created on : Feb 8, 2014, 10:23:24 PM
    Author     : Touraj
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="WEB-INF/favicon.ico">


        <link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/favicon.ico">        
        <link href="css/bootstrap1.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/bootstrap-theme.min.css.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">

    </head>

    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" >Service Hub</a>

                </div>
                <div class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" role="form" action="logout">
                        <button type="submit" class="btn btn-success">Sign out</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:useBean id="addWSDLBean"  scope="page" class="modelDAO.AddWSDLBean" />
        <form class="form-signin" action="AddWSDLServlet" method="post">

            <h2 class="form-horizontal">Add WSDL</h2>
            <input name="owner" type="text" class="form-control" placeholder="Owner" value="<%= session.getAttribute("user_name")%>">
            <input name="Category" type="text" class="form-control" placeholder="Category"  required>
            <input name="price" type="number" class="form-control" placeholder="Price" required >
            <input name="url" type="url" class="form-control" placeholder="URL" required value="<%= session.getAttribute("Error")%>"> 
            <input name="technique" type="text" class="form-control" placeholder="Technique" >
            <input name="subject" type="text" class="form-control" placeholder="Subject" required>
            <input name="description" type="text" class="form-control" placeholder="Description" required>
            <br>
            <button name ="addBtn" value="WSDLadded11" class="btn btn-lg btn-primary btn-block" type="submit">Add WSDL</button>
        </form>
        <form class="form-signin" action="AddWSDLServlet" methos="POST">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Cancel</button>
        </form>
    </div>  


    <div class ="navbar navbar-default navbar-fixed-bottom">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.jsp">Home</a></li>
                    <li><a href="aboutUs.jsp">About</a></li>
                    <li><a href="FAQ.jsp">FAQ</a></li>
                    <li><a href="contactUs.jsp">Contact</a></li>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>
