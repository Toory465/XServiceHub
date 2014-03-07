<%-- 
    Document   : SignIn
    Created on : Feb 6, 2014, 7:55:30 PM
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

        <title>Signin </title>

        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">    
        <link href="css/bootstrap.min.css" rel="stylesheet">



    </head>
    <body>

        <div class="container">

            <form class="form-signin" method="POST" action="SignInServlet" >

                <h2 class="form-signin-heading">Please sign in </h2>


                <input name="email" type="email" class="form-control" placeholder="Email address" required autofocus>
                <input name="pass"type="password" class="form-control" placeholder="Password" required>

                <label class="checkbox">
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>             
                <a href="register.jsp" class="btn btn-lg btn-primary btn-block" role="button">Register</a>
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
