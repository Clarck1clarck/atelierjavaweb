/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servelet;

import atelierjavaweb.entity.Film;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "ListerFilmServelet", urlPatterns = {"/lister_films"})
public class ListerFilmServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //1. récup la liste des films
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT f FROM Film f ORDER BY f.id");
        List<Film> films = query.getResultList();
        req.setAttribute("listeFilms", films);
        
        //2. Envoyer vers la JSP
        req.getRequestDispatcher("liste_films.jsp").forward(req, resp);
    }
    
}
