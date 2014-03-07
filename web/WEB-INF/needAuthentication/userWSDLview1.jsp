<%-- 
    Document   : userWSDLview
    Created on : Feb 10, 2014, 3:28:38 PM
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
        <!--        <link href="css/bootstrap.min.css" rel="stylesheet">-->
        <link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/favicon.ico">        
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="./css/DT_bootstrap.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

        <script type="text/javascript" language="javascript" src="./js/jquery.js"></script>
        <script type="text/javascript" language="javascript" src="./js/jquery.dataTables.js"></script>
        <script type="text/javascript" language="javascript" src="./js/sourceJS.js"></script>


    </head>
    <%

        session.setAttribute("u_id", request.getAttribute("user_id"));
        session.setAttribute("u_name", request.getAttribute("user_name"));

    %>

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
                    <a class="navbar-brand">Service Hub</a>

                </div>
                <div class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" role="form" action="logout">
                        <button type="submit" class="btn btn-success">Sign out</button>                                                                      ->
                    </form>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="jumbotron">
                <h3>Service Hub -  <%= session.getAttribute("user_name")%>   </h3 > 
                <jsp:useBean id="UQB" scope="request" class="modelDAO.UserWSDLBean" />

                <div class="table-responsive"> 
                    <div class="container" >
                        <form name="deleteForm" action="userWSDLDeleteServlet" method="post">

                            <div id="example_wrapper" class="dataTables_wrapper" role="grid"> 
                                <div class="row">

                                    <div class="span8"><div class="table table-striped" id="example_filter"></div>

                                    </div></div>

                                <table cellpadding="0" cellspacing="0" border="0" class="bordered-table zebra-striped dataTable" id="example" aria-describedby="example_info">
                                    <thead>
                                        <tr role="row">
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 50px;"></th>
                                            <th class="header headerSortDown" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-sort="ascending"  style="width: 50px;">Owner</th>

                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 50px;">Price</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 350px;">WSDL</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 350px;">Subject</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 206px;">Description</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 80px;">Technique</th>
                                            <th class="header" role="columnheader" tabindex="0" aria-controls="example" rowspan="1" colspan="1"  style="width: 80px;">Category</th></tr>
                                    </thead>
                                    <tbody role="alert" aria-live="polite" aria-relevant="all">

                                        <c:forEach var="element" items="${UQB.queries}" varStatus="index" >      
                                            <tr class="gradeA odd">

                                                <td class="vcenter"><input type="checkbox" name="selectedItems" id="blahA" value="${element.wsdl_id}"/></td>   
                                                <td class=" sorting_1"><c:out value="${element.owner}" /></td>
                                                <td class=" "><c:out value="${element.price}" /></td>
                                                <td class=" "><c:out  value="${element.wsdl}" /></td>

                                                <td class="center "> <c:out value="${element.subject}" /></td>
                                                <td class="center "> <c:out value="${element.describtion}" /></td>
                                                <td class="center "><c:out value="${element.technique}" /></td>

                                                <td class="center "><c:out value="${element.category}" /></td>

                                            </tr>
                                        </c:forEach>    

                                    </tbody></table>
                            </div>


                            <div class="form-group">
                                <!--                            <button type="submit" class="btn btn-success">Add WSDL</button>-->
                                <button name ="delete" value="deleteWSDL" class="btn btn-success btn-lg active" type="submit">Delete</button>

                            </div>
                        </form>
                        <form name="addForm" action="AddWSDLServlet" method="post">

                            <button name ="addBtn" value="WSDLadded" method="post" class="btn btn-success btn-lg active" type="submit">Add   </button>              
                        </form>

                    </div>

                    <!--                </form>-->

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
                        <!--          <a class="navbar-brand" href="#">Bootstrap theme</a>-->
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="index.jsp">Home</a></li>
                            <li><a href="aboutUs.jsp">About</a></li>
                            <li><a href="FAQ.jsp">FAQ</a></li>
                            <li><a href="contactUs.jsp">Contact</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>

            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

            <!-- Include all compiled plugins (below), or include individual files as needed -->
            <!--            <script src="js/bootstrap.min.js"></script>-->
    </body>
</html>

