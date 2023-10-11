package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LinkAndAssess;
import model.TableAssessments;
import model.TableLinks;

@WebServlet("/DeleteLinkServlet")
public class DeleteLinkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteLinkServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deleteIdParam = request.getParameter("deleteId");

        if (deleteIdParam != null && !deleteIdParam.isEmpty()) {
            int deleteId = Integer.parseInt(deleteIdParam);

            LinkAndAssessHelper linkAndAssessHelper = new LinkAndAssessHelper();
            LinkAndAssess linkToDelete = linkAndAssessHelper.getLinkAndAssessById(deleteId);

            if (linkToDelete != null) {
                linkAndAssessHelper.deleteLinkAndAssess(linkToDelete);

                // Delete from the links table
                LinkHelper linkHelper = new LinkHelper();
                TableLinks link = linkHelper.getLinkById(deleteId);

                if (link != null) {
                    linkHelper.deleteLinkInformation(link);
                }

                // Delete from the assessments table
                AssessmentHelper assessmentHelper = new AssessmentHelper();
                TableAssessments assessment = assessmentHelper.getAssessmentById(deleteId);

                if (assessment != null) {
                    assessmentHelper.deleteAssessmentInformation(assessment);
                }
            }
        }

        response.sendRedirect("index.html");
    }
}





