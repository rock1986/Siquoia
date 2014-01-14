<%-- 
    Document   : logout
    Created on : Nov 15, 2013, 11:26:49 PM
    Author     : rock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
session.invalidate();
response.sendRedirect("index.jsp");
%> 