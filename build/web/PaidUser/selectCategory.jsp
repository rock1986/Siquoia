<%-- 
    Document   : selectCategory
    Created on : Nov 28, 2013, 12:07:45 AM
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
                        <div id="login">
                            <h1>Please select a category</h1> 
                            <form name="myform" action="http://localhost:8080/Siquoia/SelectCategoryServlet" method="post">
                                <% 
                                    Connection con =ConDB.ConnectDB.getConn();
                                    Statement stmt = con.createStatement();
                                    
                                    String query = "SELECT firstlevel FROM firstlevel;";
                                    try{
                                        ResultSet rset = stmt.executeQuery(query);
                                        while (rset.next())
                                        {   String category = rset.getString("firstlevel");
//                                            request.setAttribute("category", category);
                                            out.print("<p class=\"button\">");
                                            out.print("<input type=\"submit\" value=\"");
                                            out.print(category); 
                                            out.print("\" name=\"firstlevelcategory\"/>");
                                            out.print("</p>");
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
<!--                                    <p class="button">
                                        <input type="submit" value="Random" name="category"/>
                                    </p>-->
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