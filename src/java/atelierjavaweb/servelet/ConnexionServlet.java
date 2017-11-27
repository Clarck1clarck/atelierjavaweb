/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servelet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/Connexion"})
public class ConnexionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("pseudo");
        String mdp = req.getParameter("mdp");

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("SELECT COUNT (u) FROM Utilisateur u WHERE u.pseudo=:pseudo AND u.mdp=:motDePasse");
        query.setParameter("pseudo", login);
        query.setParameter("motDePasse", mdp);
        
        long nbResult = (long) query.getSingleResult();
        
        if(nbResult>0){
            //Identifier OK
            
            req.getSession().setAttribute("pseudoUtil", login);
            resp.sendRedirect("lister_films");
        }else{
            req.getRequestDispatcher("connexion.jsp").forward(req, resp);
        }
        
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("connexion.jsp").forward(req, resp);

    }

}
