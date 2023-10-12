/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * @author Noah Arterburn - narterburn@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 9, 2023
 */

package controller;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LinkAndAssess;

@WebServlet("/ViewAllLinkAndAssessServlet")
public class ViewAllLinkAndAssessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartnerProject");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = emfactory.createEntityManager();

        List<LinkAndAssess> allLinkAndAssess = em.createQuery("SELECT la FROM LinkAndAssess la", LinkAndAssess.class).getResultList();
        em.close();

        request.setAttribute("allLinkAndAssess", allLinkAndAssess);
        request.getRequestDispatcher("/ViewAllLinks.jsp").forward(request, response);
    }
}

