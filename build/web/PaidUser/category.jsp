<%-- 
    Document   : category
    Created on : Nov 28, 2013, 1:13:30 PM
    Author     : rock
--%>

<%@page import ="java.sql.*" %>
<%@page import ="ConDB.ConnectDB" %>
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
                            <h1>Please select a topic to play</h1> 
                            <form name="myform" action="http://localhost:8080/Siquoia/CategoryServlet" method="post">
                                <table width="150%" align="right" border="0">
                                <% String category = (String)session.getAttribute("category");
                                    Connection con = ConDB.ConnectDB.getConn();
                                    Statement stmt = con.createStatement();
                                    
                                    String query = "SELECT numofsec, numofthird, id FROM firstlevel WHERE firstlevel = '"+category+"';";
                                    try{
                                        ResultSet rset = stmt.executeQuery(query);
                                        if (rset.next())
                                        {
                                            int fl_id = rset.getInt("id");
                                            int totalthird = rset.getInt("numofthird");
                                            out.print("<tr>");
                                            out.print("<td rowspan =\"");
                                            out.print(totalthird);
                                            out.print("\">");
                                            out.print("<p class=\"category button\"><input type=\"submit\" value=\"");
                                            out.print(category);
                                            out.print("\" name=\"firstlevel\"/></p>");
                                            out.print("</td>");
                                            
                                            String query1 = "SELECT numofthird, id, secondlevel FROM secondlevel WHERE fl_id = '"+fl_id+"';";
                                            Statement stmt1=con.createStatement();
                                            ResultSet rset1 = stmt1.executeQuery(query1);     
                                            
                                            
                                            if (rset1.next())
                                            {
                                                String query2 = "SELECT thirdlevel FROM thirdlevel WHERE sl_id = '"+rset1.getInt("id")+"';";
                                                Statement stmt2=con.createStatement();
                                                ResultSet rset2 = stmt2.executeQuery(query2); 
                                                int numofthird=rset1.getInt("numofthird");
                                                
                                                out.print("<td rowspan = \"");
                                                out.print(numofthird);
                                                out.print("\">");
                                                out.print("<p class=\"category button\"><input type=\"submit\" value=\"");
                                                out.print(rset1.getString("secondlevel"));
                                                out.print("\" name=\"secondlevel\"/></p>");                                                
                                                out.print("</td>"); 
                                                if (rset2.next())
                                                {
                                                    out.print("<td>");
                                                    out.print("<p class=\"category button\"><input type=\"submit\" value=\"");
                                                    out.print(rset2.getString("thirdlevel"));
                                                    out.print("\" name=\"thirdlevel\"/></p>"); 
                                                    out.print("</td>");
                                                    out.print("</tr>");
                                                }
                                                while (rset2.next())
                                                {
                                                    out.print("<tr>");
                                                    out.print("<td>");
                                                    out.print("<p class=\"category button\"><input type=\"submit\" value=\"");
                                                    out.print(rset2.getString("thirdlevel"));
                                                    out.print("\" name=\"thirdlevel\"/></p>"); 
                                                    out.print("</td>");
                                                    out.print("</tr>");
                                                }
                                            }
                                            while (rset1.next())
                                            {   
                                                String query2 = "SELECT thirdlevel FROM thirdlevel WHERE sl_id = '"+rset1.getInt("id")+"';";
                                                Statement stmt2=con.createStatement();
                                                ResultSet rset2 = stmt2.executeQuery(query2); 
                                                int numofthird=rset1.getInt("numofthird");
                                                
                                                out.print("<tr>");
                                                out.print("<td rowspan = \"");
                                                out.print(numofthird);
                                                out.print("\">");
                                                out.print("<p class=\"category button\"><input type=\"submit\" value=\"");
                                                out.print(rset1.getString("secondlevel"));
                                                out.print("\" name=\"secondlevel\"/></p>"); 
                                                out.print("</td>");
                                                
                                                if (rset2.next())
                                                {
                                                    out.print("<td>");
                                                    out.print("<p class=\"category button\"><input type=\"submit\" value=\"");
                                                    out.print(rset2.getString("thirdlevel"));
                                                    out.print("\" name=\"thirdlevel\"/></p>"); 
                                                    out.print("</td>");
                                                    out.print("</tr>");
                                                }                                                

                                                while (rset2.next())
                                                {
                                                    out.print("<tr>");
                                                    out.print("<td>");
                                                    out.print("<p class=\"category button\"><input type=\"submit\" value=\"");
                                                    out.print(rset2.getString("thirdlevel"));
                                                    out.print("\" name=\"thirdlevel\"/></p>"); 
                                                    out.print("</td>");
                                                    out.print("</tr>");
                                                } 
                                            }
                                        }
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                                    finally
                                    {
                                        ConDB.ConnectDB.disconDB();
                                    }
                                    %>
                                </table>
                                <table align="left">
                                    <tr>
                                        <td>
                                            <p class="button"><input type="submit" value="Back" name="backtocategory" /></p>
                                        </td>
                                        <td>
                                            <p class="button"><input type="submit" value="Main Page" name="mainpage" /></p>
                                        </td>
                                    </tr>
                                </table>
<!--                                    <p class="select button">
                                        <input type="submit" value="Random" name="category"/>
                                    </p>-->
                            </form>						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>