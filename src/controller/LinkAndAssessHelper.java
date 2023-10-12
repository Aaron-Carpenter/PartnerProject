/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * @author Noah Arterburn - narterburn@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 9, 2023
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.LinkAndAssess;
import model.TableAssessments;
import model.TableLinks;

public class LinkAndAssessHelper {
    private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartnerProject");

    public void insertLinkAndAssessInformation(LinkAndAssess linkAndAssess) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(linkAndAssess);
        em.getTransaction().commit();
        em.close();
    }

    public List<LinkAndAssess> showAllLinkAndAssess() {
        EntityManager em = emfactory.createEntityManager();
        List<LinkAndAssess> allLinkAndAssess = em.createQuery("SELECT la FROM LinkAndAssess la", LinkAndAssess.class).getResultList();
        em.close();
        return allLinkAndAssess;
    }

    public void deleteLinkAndAssessInformation(LinkAndAssess toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<LinkAndAssess> typedQuery = em.createQuery("SELECT la FROM LinkAndAssess la WHERE la.id = :selectedId", LinkAndAssess.class);

        typedQuery.setParameter("selectedId", toDelete.getId());
        typedQuery.setMaxResults(1);

        LinkAndAssess result = typedQuery.getSingleResult();

        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public void updateLinkAndAssessInformation(LinkAndAssess toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }

    public LinkAndAssess getLinkAndAssessById(int id) {
        EntityManager em = emfactory.createEntityManager();
        return em.find(LinkAndAssess.class, id);
    }
    public void fetchAndInsertData() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartnerProject");
        EntityManager em = emfactory.createEntityManager();

        try {
            em.getTransaction().begin();

            Query deleteQuery = em.createQuery("DELETE FROM LinkAndAssess");
            deleteQuery.executeUpdate();

            TypedQuery<TableLinks> linksQuery = em.createQuery("SELECT l FROM TableLinks l", TableLinks.class);
            List<TableLinks> links = linksQuery.getResultList();

            TypedQuery<TableAssessments> assessmentsQuery = em.createQuery("SELECT a FROM TableAssessments a", TableAssessments.class);
            List<TableAssessments> assessments = assessmentsQuery.getResultList();

            for (int i = 0; i < links.size(); i++) {
                TableLinks link = links.get(i);
                TableAssessments assessment = assessments.get(i % assessments.size());

                LinkAndAssess entity = new LinkAndAssess(link.getLinkName(), link.getLink(), link.getDescription(), link.getTime(), assessment.getAssessment(), assessment.getSeverity());
                em.persist(entity);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteLinkAndAssess(LinkAndAssess linkAndAssess) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();

        linkAndAssess = em.find(LinkAndAssess.class, linkAndAssess.getId());
        em.remove(linkAndAssess);

        em.getTransaction().commit();
        em.close();
    }


}
