<%-- 
    Document   : liste_pays
    Created on : 24 nov. 2017, 14:58:29
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
        <h1>Liste des pays</h1>
        <table>
            <c:forEach items="${listePays}" var="pays">
                <tr>
                    <td>${pays.id}</td>
                    <td>${pays.nom}</td>
                </tr>
            </c:forEach>
        </table>        
    </body>
</html>
