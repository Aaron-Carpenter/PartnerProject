
/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 7, 2023
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import model.TableAssessments;

public class AssessmentHelper {

    private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartnerProject");

    public void insertAssessmentInformation(TableAssessments assessment) { // Updated method name and parameter type
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(assessment);
        em.getTransaction().commit();
        em.close();
    }

    public List<TableAssessments> showAllAssessments() {
        EntityManager em = emfactory.createEntityManager();
        List<TableAssessments> allAssessments = em.createQuery("SELECT a FROM TableAssessments a", TableAssessments.class).getResultList();
        em.close();
        return allAssessments;
    }

    public void deleteAssessmentInformation(TableAssessments toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<TableAssessments> typedQuery = em.createQuery("SELECT a FROM TableAssessments a WHERE a.id = :selectedId", TableAssessments.class);

        typedQuery.setParameter("selectedId", toDelete.getId());
        typedQuery.setMaxResults(1);

        TableAssessments result = typedQuery.getSingleResult();

        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public void updateAssessmentInformation(TableAssessments toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }
}
