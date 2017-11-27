/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servelet;

import atelierjavaweb.entity.Pays;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "ListerPaysServelet", urlPatterns = {"/lister_pays"})
public class ListerPaysServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //1. récup la liste des pays
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        List<Pays> listePays = em.createQuery("SELECT P from Pays p ORDER BY p.id").getResultList();
        req.setAttribute("listePays", listePays);
        
        //2. Envoyer vers la JSP
        req.getRequestDispatcher("liste_pays.jsp").forward(req, resp);
    }

   
}
