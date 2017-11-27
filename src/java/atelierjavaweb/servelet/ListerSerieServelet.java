/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servelet;

import atelierjavaweb.entity.Serie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.eclipse.persistence.logging.SessionLog;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "ListerSerieServelet", urlPatterns = {"/lister_series"})
public class ListerSerieServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //1. récup la liste des pays
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    Query query = em.createQuery("SELECT s FROM Serie s ORDER BY s.id");
    List<Serie> series = query.getResultList();
    req.setAttribute("listeSeries", series);
    
    //2. Envoyer vers la JSP
    req.getRequestDispatcher("liste_series.jsp").forward(req, resp);
        
    }
}
