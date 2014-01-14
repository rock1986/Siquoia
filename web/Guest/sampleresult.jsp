<%-- 
    Document   : result
    Created on : Nov 18, 2013, 12:38:42 AM
    Author     : rock
--%>

<%@page import="LoginServ.LoginBean"%>
<%@page import="QuestionServ.QueBean"%>
<%@page import="QuestionServ.StatusBean"%>
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
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>

    <% LoginBean currentUser=(LoginBean)session.getAttribute("currentSessionUser");%>
    <% StatusBean currentStatus=(StatusBean)session.getAttribute("currentStatus");%>
    <body>
        <div class="container">
            <header>
                <h1>Siquoia</h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <div id="wrapper">
                        <div id="login">
                            <h1>Congratulations!<br />You have finished the sample game.</h1> 
                            <h2>Your score is&nbsp;<%= currentStatus.getCorrect()%>!</h2>
                            
                            <form name="myform" action="Guest/guest.jsp" method="post">
                                <p class="login button">
                                    <input type="submit" value="MainPage" name="back"/>                                 
				</p>
                            </form>
                        </div>						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
