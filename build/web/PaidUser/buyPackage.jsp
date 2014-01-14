<%-- 
    Document   : buyPackage
    Created on : Dec 6, 2013, 7:05:23 PM
    Author     : rock
--%>

<%@page import="java.sql.*"%>
<%@page import="LoginServ.LoginBean"%>
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
                             <% LoginBean currentUser=(LoginBean)session.getAttribute("currentSessionUser");%>
                            <h1>Please choose the Package</h1>
                            <form name="myform" action="http://localhost:8080/Siquoia/BuyPackServlet" method="post">
                                <select name="package">
                                <%
                                    int id=currentUser.getId();
                                    Connection con = ConDB.ConnectDB.getConn();
                                    Statement stmt = con.createStatement();
                                    String query = "SELECT price, category, package_id FROM package WHERE package_id not IN "
                                            + "(SELECT package_id FROM package_player WHERE user_id='"+id+"')";
                                    
                                    try{
                                        ResultSet rset = stmt.executeQuery(query);
                                        
                                        if (!rset.next())
                                        {
                                            out.print("<option value=\"\">");
                                            out.print("No More New Packages");
                                        }
                                        else
                                        {
                                            out.print("<option value=\"");
                                            out.print(rset.getString("category"));
                                            out.print("\">");
                                            out.print(rset.getString("category"));
                                            out.print("-------------------");
                                            out.print(rset.getInt("price"));
                                            out.print(" points");
                                        }
                                        while (rset.next())
                                        {
                                            out.print("<option value=\"");
                                            out.print(rset.getString("category"));
                                            out.print("\">");
                                            out.print(rset.getString("category"));
                                            out.print("-------------------");
                                            out.print(rset.getInt("price"));
                                            out.print(" points");
                                        }
                                        
                                    }
                                    catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    finally
                                    {
                                        ConDB.ConnectDB.disconDB();
                                    }                                    
                                %>  
                                </select>
                                <p class="button"> 
                                    <input type="submit" value="Purchase" name="purchase" /> 
				</p> 
                                <p class="button"> 
                                    <input type="submit" value="Category" name="backtocatetory" /> 
				</p>                                
                                <p class="button"> 
                                    <input type="submit" value="Main Page" name="mainpage" /> 
				</p>                                
                            </form>
                        </div>						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
