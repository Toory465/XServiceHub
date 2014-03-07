<%-- 
    Document   : register
    Created on : Feb 8, 2014, 8:33:17 PM
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


        <link href="css/bootstrap1.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/bootstrap-theme.min.css.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">

        <script type="text/javascript" language="javascript" src="./js/jquery.js"></script>
        <script type="text/javascript" language="javascript">
            $(document).ready(function() {
                $("#reg-form").submit(function() {
                    var value=$('#email').val();
                    $.ajax({
                        type: "POST",
                        url: "./RegisterationServlet",
                        data: {"email":value},
                        success: function (data) {
                            var result=data;
                            alert(result);
                        }
                        
                    });
                    
                    if($('#pass').val()!=$('#cpass').val()){
                        alert('Password not matches');
                        return false;
                    }
                    return true;
                })
            })
            
        </script>
    </head>
    <body>
        <div class="container" >
            <form class="form-signin" action="RegisterationServlet" method="post" id="reg-form">

                <h2 class="form-signin-heading">Please Fill the following information</h2>
                <table style="font-size: 12px" cellpadding="0" cellspacing="0" border="0" class="bordered-table zebra-striped dataTable" id="example" aria-describedby="example_info" >

                    <input name="firstName" type="text" class="form-control" placeholder="First Name" required autofocus>
                    <input name="family" type="text" class="form-control" placeholder="Family" required>
                    <input name="org" type="text" class="form-control" placeholder="Organization" required >
                    <input id="email" name="email" type="email" class="form-control" placeholder="Email address" required >
                    <input name="webSite" type="url" class="form-control" placeholder="Web Site" >
                    <input name="pass" type="password" class="form-control" placeholder="Password" required id="pass">
                    <input name="repPass" type="password" class="form-control" placeholder="ConfirmPassword" required id="cpass" onblur="checkPass()">
                </table>
                <button name ="registerBtn" value="register" class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
                <div></div>

            </form>
            <form class="form-signin" action="RegisterationServlet" >
                <button name ="registerBtn" class="btn btn-lg btn-primary btn-block" type="submit">Cancel</button>
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
                        <li><a href="ContactUs.jsp">Contact</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
