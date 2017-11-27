<%-- 
    Document   : lister_films
    Created on : 23 nov. 2017, 15:20:21
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
        <h1>Liste des films</h1>
        <table>
            <tbody>
                <c:forEach items="${listeFilms}" var="film">
                    <tr>
                        <td>${film.id}</td>
                        <td>${film.titre}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
