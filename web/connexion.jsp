<%-- 
    Document   : connection
    Created on : 27 nov. 2017, 13:42:50
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

        <div>
            <c:import url="_MENU.jsp"></c:import>
        </div>

        <div>
            <h1>Identifiez vous</h1>
            <form style="text-align: center;" method="post">
                <label>Pseudo</label>
                <input type="text" name="pseudo"/>
                <br>
                <label>Mot-de-passe</label>
                <input type="password" name="mdp"/>
                <br>
                <input type="submit" value="Connesion"/>
            </form>
        </div>
    </body>
</html>