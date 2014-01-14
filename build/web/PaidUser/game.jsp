<%-- 
    Document   : game
    Created on : Nov 28, 2013, 12:03:28 AM
    Author     : rock
--%>

<%@page import="QuestionServ.QueBean"%>
<%@page import="LoginServ.LoginBean"%>
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
        <link rel="stylesheet" type="text/css" href="../css/demo.css" />
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>
    
    <% QueBean currentQuestion=(QueBean)session.getAttribute("currentSessionQuestion");%>
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
                            <h1>Question&nbsp;<%= currentStatus.getCount()+1 %></h1> 
                            <p><%= currentQuestion.getQuestion()%></p>
                            <form name="myform" action="http://localhost:8080/Siquoia/NextServlet" method="post">
                                    <input type="radio" value="A" name="choice" checked/><%= currentQuestion.getChoiceA()%><br />
                                    <input type="radio" value="B" name="choice" /><%= currentQuestion.getChoiceB()%><br />
                                    <input type="radio" value="C" name="choice" /><%= currentQuestion.getChoiceC()%><br /> 
                                    <input type="radio" value="D" name="choice" /><%= currentQuestion.getChoiceD()%><br />     
                                <p class="login button">
                                    <input type="submit" value="Next" name="next"/>                                 
				</p>
                            </form>
                        </div>						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>