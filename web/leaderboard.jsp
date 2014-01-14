<%-- 
    Document   : leaderboard
    Created on : Nov 23, 2013, 11:22:59 AM
    Author     : rock
--%>
<%@page import="LoginServ.LoginBean"%>
<%@page import ="java.sql.*" %>
<%@page import ="ConDB.ConnectDB" %>
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
        <link rel="stylesheet" type="text/css" href="css/style_1.css" />
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
                            <h1>Welcome <%=currentUser.getFirstname()+ " " +currentUser.getLastname() %></h1>
                            <h2>Top 10</h2>
                            <form name="myform" action="http://localhost:8080/Siquoia/MPServlet" method="post">
                                <table id="table"> 
                                    <tr>
                                        <th>Name</th>
                                        <th>Score</th>
                                    </tr>
                                    <%
                                        Connection con = ConDB.ConnectDB.getConn();
                                        Statement stmt = con.createStatement();
                                        String query = "SELECT Max(user_id) as max from user;";
                                        try{
                                            ResultSet rset1 = stmt.executeQuery(query);
                                            if (rset1.next())
                                            {
                                                int max = rset1.getInt("max");                    
                                                query = "SELECT firstname, lastname, highscore FROM user, player "
                                                            + "WHERE user.user_id=player.user_id and player.ispaid='1' "
                                                            + "ORDER BY user.user_id DESC;";
                                                ResultSet rset2= stmt.executeQuery(query);
                                                if (max > 10)
                                                {
                                                    int count=10;
                                                    while(count!=0)
                                                    {
                                                        if (rset2.next())
                                                        {
                                                            out.print("<tr>");
                                                            out.print("<td>");
                                                            out.print(rset2.getString("firstname")+" "+rset2.getString("lastname"));
                                                            out.print("<td>");
                                                            out.print(rset2.getInt("highscore"));
                                                            out.print("</tr>");
                                                        }
                                                        count--;
                                                    }
                                                }
                                                else
                                                {
                                                        while (rset2.next())
                                                        {
                                                            out.print("<tr>");
                                                            out.print("<td>");
                                                            out.print(rset2.getString("firstname")+" "+rset2.getString("lastname"));
                                                            out.print("<td>");
                                                            out.print(rset2.getInt("highscore"));
                                                            out.print("</tr>");
                                                        }                
                                                }
                                            }
                                        }
                                        catch (Exception e)
                                        {
                                            e.printStackTrace();
                                        }
                                        finally
                                        {
                                            ConnectDB.disconDB();
                                        }

                                    %>                           
                                </table>
                                <p class="login button"> 
                                    <input type="submit" value="Main Page" /> 
				</p> 
                            </form>
                        </div>						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>