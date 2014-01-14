<%-- 
    Document   : viewprofile
    Created on : Nov 25, 2013, 12:30:32 AM
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
                            <h1>Welcome <%=currentUser.getFirstname()+ " " +currentUser.getLastname() %></h1>
                            <h2>Your Profile</h2>
                            <form name="myform" action="http://localhost:8080/Siquoia/MPServlet" method="post">
                                <table id="table">
                                    <tr>
                                        <td>Your Score</td>
                                        <td><%=currentUser.getHighscore()%></td>
                                    </tr>
                                    <%
                                        Connection con = ConDB.ConnectDB.getConn();
                                        Statement stmt = con.createStatement();
                                        int id = currentUser.getId();
                                        String query1 = "SELECT point FROM player WHERE user_id='"+id+"';";
                                        String query2 = "SELECT name FROM achie WHERE achie_id in "
                                                + "(SELECT achie_id FROM player_achie WHERE user_id='"+id+"');";
                                        try{
                                            
                                            ResultSet rset1 = stmt.executeQuery(query1);
                                            int point=0;
                                            if (rset1.next())
                                            {
                                                point = rset1.getInt("point");
                                                out.print("<tr>");
                                                out.print("<td>");
                                                out.print("Your Points");
                                                out.print("</td>");
                                                out.print("<td>");
                                                out.print(rset1.getInt("point"));
                                                out.print("</td>");
                                                out.print("</tr>");
                                            }
                                            String query3="SELECT * FROM achie WHERE points<'"+point+"' and achie_id not IN (SELECT achie_id FROM player_achie WHERE user_id='"+id+"');";
                                            rset1 = stmt.executeQuery(query3);
                                            while (rset1.next())
                                            {
                                                int achie_id= rset1.getInt("achie_id");
                                                query1 = "INSERT INTO player_achie(user_id,achie_id) VALUES('"+id+"','"+achie_id+"');";
                                                stmt.executeUpdate(query1);
                                            }
                                            ResultSet rset2 = stmt.executeQuery(query2);
                                            out.print("<tr>");
                                            out.print("<td>");
                                            out.print("Achievements");
                                            out.print("</td>");
                                            out.print("<td>");
                                            if (rset2.next())
                                            {
                                                out.print("<li>");
                                                out.print(rset2.getString("name"));
                                                out.print("</li>");
                                            }
                                            else
                                            {
                                                out.print("No Achievements");
                                            }
                                            out.print("</td>");
                                            out.print("</tr>");                                            
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
