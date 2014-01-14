<%-- 
    Document   : Login
    Created on : Nov 10, 2013, 11:43:34 AM
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
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    
    <jsp:useBean id="newuser" class="RegServ.RegBean" scope="application" />
    
    <body>
        <div class="container">
            <header>
                <h1>Siquoia</h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <div id="wrapper">
                        <div id="register">
                            <form  id="mf" name="myform" action="http://localhost:8080/Siquoia/RegisterServlet" method="post"> 
                                <h1> Sign up </h1>
                                    <% if( newuser.isHasUser())
                                            out.print("<span class=\"red\">User already exists! Please Login!</span>");
                                    %>
                                <p> 
                                    <label for="lname" class="youlname" data-icon="e" > Last Name</label>
                                    <input id="lnamesignup" name="lnamesignup" required="required" type="text" placeholder="Last Name" value=""
                                           <% if (!newuser.isIsFirstTime())
                                           {
                                                    if (!newuser.isHasUser())
                                                    {
                                                        out.print("value=\"${newuser.getFirstname()}\"");
                                                        out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                                    }
                                                    else
                                                        out.print("value=\"\"");
                                                    
                                           }
                                           %>
                                                />
                                    <% if(!newuser.isIsFirstTime())
                                           {
                                            if (!newuser.isHasUser())
                                                out.print("<span class=\"red\">First Name can not be spaces!</span>");
                                           }
                                    %>
                                </p>                              
                                <p> 
                                    <label for="fname" class="youfname" data-icon="e" > First Name</label>
                                    <input id="fnamesignup" name="fnamesignup" required="required" type="text" placeholder="First Name" value=""
                                           <% if (!newuser.isIsFirstTime())
                                           {
                                                    if (!newuser.isHasUser())
                                                    {
                                                        out.print("value=\"${newuser.getLastname()}\"");
                                                        out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                                    }
                                                    else
                                                        out.print("value=\"\"");
                                           
                                                       
                                            }       %>
                                /> 
                                    <% if(!newuser.isIsFirstTime() )
                                           {
                                           if (!newuser.isHasUser())
                                                out.print("<span class=\"red\">Last Name can not be spaces!</span>");
                                           }
                                    %>
                                </p>                                
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                                    <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com" value=""
                                    <% String email=newuser.getUseremail(); 
                                       if (!newuser.isIsFirstTime() && !newuser.isValidEmail(email))
                                       {                                           
                                                    if (!newuser.isHasUser())
                                                    {
                                                        out.print("value=\"${newuser.getUseremail()}\"");
                                                        out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                                    }  
                                                    else
                                                        out.print("value=\"\"");
                                           
                                           
                                       }
                                    %>
                                    />
                                    <% if (!newuser.isIsFirstTime()){
                                            if(!newuser.isValidEmail(email)){
                                                out.print("<span class=\"red\">Invalid email address!</span>");
                                            }
                                       } %>                                     
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                                    <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO" value=""
                                    <% String password=newuser.getUserpassword(); 
                                       if (!newuser.isIsFirstTime() && !newuser.isGoodPassword(password))
                                           {
                                                    if (!newuser.isHasUser())
                                                    {
                                                        out.print("value=\"${newuser.getUserpassword()}\"");
                                                        out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                                    }
                                                    else
                                                        out.print("value=\"\"");
                                                                                      
                                           
                                       }
                                    %>
                                    />
                                    <% if (!newuser.isIsFirstTime() && !newuser.isGoodPassword(password)){
                                        if (!newuser.isHasUser())
                                           out.print("<span class=\"red\">Please choose at least 10 characters including Uppercase letter, number and special characters!</span>");
                                       } %>                                     
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO" value="" 
                                    <% if (!newuser.isIsFirstTime() && !newuser.samePassword())
                                           {
                                                    if (!newuser.isHasUser())
                                                    {
                                                        out.print("value=\"${newuser.getgetUserpassword_conf()}\"");
                                                        out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                                    }
                                                    else
                                                        out.print("value=\"\"");
                                                                                  
                                           
                                       } 
                                    %>
                                    />
                                    <% if (!newuser.isIsFirstTime() && !newuser.samePassword()){
                                            if (!newuser.isHasUser())
                                                out.print("<span class=\"red\">Password mismatch!</span>");
                                       } %>                                
                                </p>
                                <p class="signin button"> 
					<input type="submit" value="Sign up"/> 
				</p>
                                <p class="change_link">  
					Already a member ?
					<a href="index.jsp"> Go and log in </a>
				</p>
                            </form>
                        </div>			
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>