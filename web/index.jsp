<%-- 
    Document   : index
    Created on : Feb 5, 2014, 8:10:41 PM
    Author     : Touraj
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <!-- Bootstrap -->
        <link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/favicon.ico">        
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="./css/DT_bootstrap.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

        <script type="text/javascript" language="javascript" src="./js/jquery.js"></script>
        <script type="text/javascript" language="javascript" src="./js/jquery.dataTables.js"></script>
        <script type="text/javascript" language="javascript" src="./js/sourceJS.js"></script>


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
                    <a class="navbar-brand" href="#">Service Hub</a>
                </div>
                <div class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" role="form" action="/">                       
                        <a href="signIn.jsp" class="btn btn-success  active" role="button">Sign In</a>
                        <a href="register.jsp" class="btn btn-success  active" role="button">Sign Up</a>                     
                        </a></button>
                    </form>
                </div>!--/.navbar-collapse -->
            </div>
        </div>
        <div class="container">
            <div class="jumbotron">
                <h1>Service Hub </h1>
                <form class="navbar-form navbar-right" role="form">


                </form>



                <jsp:useBean id="queriesBean" scope="request" class="modelDAO.IndexQueryBean" />
                <form name="testForm" action="/XServiceHub/" method="post">
                    <div class="table-responsive"> 
                        <div class="container" >

                            <div id="example_wrapper" class="dataTables_wrapper" role="grid"> 
                                <div class="row">

                                    <div class="span8"><div class="table table-striped" id="example_filter"></div>

                                    </div></div>

                                <table style="font-size: 12px" cellpadding="0" cellspacing="0" border="0" class="bordered-table zebra-striped dataTable" id="example" aria-describedby="example_info" >
                                    <thead>
                                        <tr role="row">
                                            <th class="header headerSortDown" role="columnheader"  tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-sort="ascending"  style="width: 50px;">Owner</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 50px;">Price</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 250px;">WSDL</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 100px;">Subject</th>
                                            <th class="header" role="columnh
                                                eader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 406px;">Description</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 80px;">Technique</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 40px;">Category</th></tr>
                                    </thead>
                                    <tbody role="alert" aria-live="polite" aria-relevant="all">                                
                                        <c:forEach var="element" items="${queriesBean.queries}" varStatus="index" >      
                                            <tr class="gradeA odd">
                                                <td class=" sorting_1"><c:out value="${element.owner}" /></td>
                                                <td class=" "><c:out value="${element.price}"/></td>
                                                <td class=" "><a href="${element.wsdl}"><c:out value="${element.wsdl}"/></a></td>
                                                <td class="center "> <c:out value="${element.subject}" /></td>
                                                <td class="center " style="font-size: 10px"> <c:out value="${element.describtion}" /></td>
                                                <td class="center "><c:out value="${element.technique}" /></td>
                                                <td class="center "><c:out value="${element.category}" /></td>

                                            </tr>
                                        </c:forEach>    

                                    </tbody></table>


                            </div>

                        </div>
                    </div>

                </form>

            </div>
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
