<%-- 
    Document   : submitQuestion
    Created on : Nov 27, 2013, 11:52:56 AM
    Author     : rock
--%>

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
                            <p>To submit a question please fill in the blank and then select the right answer!</p>
                            <form  name="myform" action="http://localhost:8080/Siquoia/SubmitServlet" method="post">
                                <input type="text" value="" name="question" placeholder="Question" style="margin-top: 10px"/>
                                    <br /><br />
                                    <input type="radio" value="A" name="choice" />A&nbsp;<input type="text" value="" name="choiceA" placeholder="Choice A" style="width:80%"/>
                                    <br /><br />
                                    <input type="radio" value="B" name="choice" />B&nbsp;<input type="text" value="" name="choiceB" placeholder="Choice B" style="width:80%"/>
                                    <br /><br />
                                    <input type="radio" value="C" name="choice" />C&nbsp;<input type="text" value="" name="choiceC" placeholder="Choice C" style="width:80%"/>
                                    <br /><br />
                                    <input type="radio" value="D" name="choice" />D&nbsp;<input type="text" value="" name="choiceD" placeholder="Choice D" style="width:80%"/>
                                    <br /><br />     
                                <p class="login button">
                                    <input type="submit" value="Next" name="submitnext"/>                                 
				</p>
                                <p class="login button">
                                    <input type="submit" value="Finish" name="finish"/>                                 
				</p> 
                                <p class="login button">
                                    <input type="submit" value="Main Page" name="mainpage"/>                                 
				</p>                                     
                            </form>
                        </div>						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
