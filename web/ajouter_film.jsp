<%-- 
    Document   : ajouter_film
    Created on : 24 nov. 2017, 10:15:31
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
    </div>
    <h1>Nouveau film</h1>
    <form method="post">
        <label>Titre</label>
        <input name="titre">
        <br>
        <label>Synopsis</label>
        <textarea name="synopsis"></textarea>
        <br>
        <label>Année</label>
        <input name="annee" type="number" min="1900" max="2020"/>
        <br>
        <label>Durée</label>
        <input name="duree" type="number" min="1"/>
        <br>
        <label>Genre</label>
        <select name="genre_id">
            <c:forEach items="${listeGenres}" var="genreAct">
                <option value="${genreAct.id}">${genreAct.nom}</option>
            </c:forEach>
        </select>
        <br>
        <input type="submit" value="Enregistrer"/>
    </form>
</body>
</html>
