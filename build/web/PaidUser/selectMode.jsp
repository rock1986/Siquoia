<%-- 
    Document   : selectMode
    Created on : Nov 30, 2013, 8:15:22 PM
    Author     : rock
--%>

<%@page import="LoginServ.LoginBean"%>
<%@page import = "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Simple Intelligence Quotient Increasing Application</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="../css/demo.css" />
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Siquoia</h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <div id="wrapper">
                        <div id="login">
                            <% LoginBean currentUser=(LoginBean)session.getAttribute("currentSessionUser");%>
                            <h1><%=currentUser.getFirstname()%>, please choose a mode!</h1>                          
                            <form name="myform" action="http://localhost:8080/Siquoia/ModeServlet" method="post">
                                <p class="button"> 
                                    <input type="submit" value="Practical Mode" name="mode" title="This mode is without time limit, and you can not earn points under this mode"/> 
				</p>
                                <p class="button"> 
                                    <input type="submit" value="Timed Mode" name="mode" title="You have only 20 seconds to answer each question, one point for correct answer" /> 
				</p>
                                <table align="center">
                                    <tr>
                                        <td>
                                            <p class="button"><input type="submit" value="Back" name="back" /></p>
                                        </td>
                                        <td>
                                            <p class="button"><input type="submit" value="Main Page" name="mainpage" /></p>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
