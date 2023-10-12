/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * @author Noah Arterburn - narterburn@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 9, 2023
 */
package controller;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import model.LinkAndAssess;
import model.TableAssessments;
import model.TableLinks;


public class LinkHelper {

    private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartnerProject");

    public void insertLinkInformation(TableLinks li) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(li);
        em.getTransaction().commit();
        em.close();
    }

    public List<TableLinks> showAllInformation() {
        EntityManager em = emfactory.createEntityManager();
        List<TableLinks> allLinks = em.createQuery("SELECT c FROM TableLinks c", TableLinks.class).getResultList();
        em.close();
        return allLinks;
    }

    public void deleteLinkInformation(TableLinks toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<TableLinks> typedQuery = em.createQuery("SELECT li FROM TableLinks li WHERE li.id = :selectedId", TableLinks.class);

        typedQuery.setParameter("selectedId", toDelete.getId());
        typedQuery.setMaxResults(1);

        TableLinks result = typedQuery.getSingleResult();

        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public void updateLinkInformation(TableLinks toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }

    public TableLinks getLinkById(int id) {
        EntityManager em = emfactory.createEntityManager();
        return em.find(TableLinks.class, id);
    }



    
}