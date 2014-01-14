<%-- 
    Document   : verifyQue
    Created on : Dec 9, 2013, 12:55:13 AM
    Author     : rock
--%>

<%@page import="java.sql.*"%>
<%@page import="LoginServ.AdminBean"%>
<%@page import="VerifyQueServ.VerifyQuestion"%>
<%@page import="QuestionServ.QueBean"%>
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

    <% QueBean que = new QueBean();
        que = (QueBean)session.getAttribute("currentQuestion");
    %>
    <body>
        <div class="container">
            <header>
                <h1>Siquoia</h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <div id="wrapper">
                        <div id="login"> 
                            <h2>Make sure you select category</h2><br />                            
                            <form name="myform" action="http://localhost:8080/Siquoia/VerifyServlet" method="post">
                                    <p style="font-size:20px"><%= que.getQuestion()%></p>
                                    <input type="radio" value="A" name="choice" <%if (que.getRightAnswer().equals("A")) out.print("checked");%>/><%= que.getChoiceA()%><br />
                                    <input type="radio" value="B" name="choice" <%if (que.getRightAnswer().equals("B")) out.print("checked");%>/><%= que.getChoiceB()%><br />
                                    <input type="radio" value="C" name="choice" <%if (que.getRightAnswer().equals("C")) out.print("checked");%>/><%= que.getChoiceC()%><br /> 
                                    <input type="radio" value="D" name="choice" <%if (que.getRightAnswer().equals("D")) out.print("checked");%>/><%= que.getChoiceD()%><br />
                                    <select name="category">
                                    <% Connection con = ConDB.ConnectDB.getConn();
                                       Statement stmt = con.createStatement();
                                       String query="SELECT * FROM thirdlevel;";
                                       ResultSet rset = stmt.executeQuery(query);
                                       while (rset.next())
                                       {
                                           out.print("<option value=\"");
                                           out.print(rset.getString("thirdlevel"));
                                           out.print("\">");
                                           out.print(rset.getString("thirdlevel"));
                                           out.print("</option>");
                                       }
                                    %>
                                    </select>
                                  <table>
                                      <tr>
                                     <td>
                                        <p class="button">
                                            <input type="submit" value="Approve" name="approve"  />                                 
                                        </p>
                                     </td>
                                     <td>                                
                                        <p class="button">
                                            <input type="submit" value="Decline" name="decline" />                                 
                                        </p>
                                    </td>
                                    </tr>
                                  </table>
                                   <p class="button"><input type="submit" value="Main Page" name="mainpage" /></p>                                      
                            </form>
                        </div>						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>