<%-- 
    Document   : Login
    Created on : Nov 10, 2013, 11:43:34 AM
    Author     : rock
--%>

<%@page import="LoginServ.LoginBean"%>
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
                    <jsp:useBean id="user" class="LoginServ.LoginBean" scope="application" />

                    <body>
                        <div class="container">
                            <header>
                                <h1>Siquoia</h1>
                            </header>
                            <section>				
                                <div id="container_demo" >
                                    <div id="wrapper">
                                        <div id="login">
                                            <form  name="myform" action="http://localhost:8080/Siquoia/LoginServlet" method="post"> 
                                                <h1>Log in</h1>
                                                <%   LoginBean currentUser = (LoginBean) session.getAttribute("currentSessionUser");
                                                     if (currentUser != null) {
                                                        if (!user.isFirsttime()) {                     
                                                            if (currentUser.getStatus().equals("InvalidUser")) {
                                                                out.print("<span class=\"red\">No match user! Please check your email and make sure you have registered before</span>");
                                                            }
                                                            if (currentUser.getStatus().equals("InvalidPassword")) {
                                                                out.print("<span class=\"red\">Wrong Password!</span>");
                                                            }
                                                            out.print("</p>");
                                                        }
                                                    }
                                                %>
                                                <p> 
                                                    <label for="username" class="uname" data-icon="u" > Your email </label>
                                                    <input id="username" name="useremail" required="required" type="text" placeholder="mymail@mail.com"/>
                                                </p>
                                                <p> 
                                                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                                                    <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                                </p>

                                                <p class="login button"> 
                                                    <input type="submit" value="Login" /> 
                                                </p>
                                                <p class="change_link">
                                                    Not a member yet ?
                                                    <a href="registerIndex.jsp">Join us</a>
                                                </p>
                                            </form>
                                        </div>						
                                    </div>
                                </div>  
                            </section>
                        </div>
                    </body>
</html>