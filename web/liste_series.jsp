<%-- 
    Document   : liste_serie.jsp
    Created on : 24 nov. 2017, 16:25:28
    Author     : Administrateur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="_MENU.jsp"></c:import>
        <h1>Liste des séries</h1>
        <table>
            <tbody>
                <c:forEach items="${listeSeries}" var="serie">
                    <tr>
                        <td>${serie.id}</td>
                        <td>${serie.titre}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
