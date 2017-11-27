/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servelet;

import atelierjavaweb.entity.Film;
import static atelierjavaweb.entity.Film_.genre;
import atelierjavaweb.entity.Genre;
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
@WebServlet(name = "AjouterFilmServelet", urlPatterns = {"/ajouter_film"})
public class AjouterFilmServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        
        Film f = new Film();
        f.setTitre(req.getParameter("titre"));
        f.setSynopsis(req.getParameter("synopsis"));
        f.setAnnee(Integer.valueOf(req.getParameter("annee")));
        f.setDuree(Integer.valueOf(req.getParameter("duree")));
        
        Genre g = em.find(Genre.class, Long.valueOf(req.getParameter("genre_id")));
        f.setGenre(g);
        g.getFilmList().add(f);
        

        em.persist(f);

        em.getTransaction().commit();

        //RAVOYER JSP VERS LISTER FILMS
        resp.sendRedirect("lister_films");
//        req.getRequestDispatcher("lister_films").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT g from Genre g ORDER BY g.nom");
        List<Genre> genres = query.getResultList();
        //Set attreibute
        req.setAttribute("listeGenres", genres);
        //Forward vers jsp
        req.getRequestDispatcher("ajouter_film.jsp").forward(req, resp);

    }
}
