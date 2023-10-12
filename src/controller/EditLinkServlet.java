/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * @author Noah Arterburn - narterburn@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 9, 2023
 */

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TableAssessments;
import model.TableLinks;

@WebServlet("/EditLinkServlet")
public class EditLinkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditLinkServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedIdParam = request.getParameter("id");
        int selectedId = 0;

        if (selectedIdParam != null && !selectedIdParam.isEmpty()) {
            selectedId = Integer.parseInt(selectedIdParam);
        }
        
        LinkHelper linkHelper = new LinkHelper();
        TableLinks existingLink = linkHelper.getLinkById(selectedId);

        if (existingLink != null) {
            String newName = request.getParameter("newName");
            String newUrl = request.getParameter("newURL");
            String newDescription = request.getParameter("newDescription");

            if (newName != null && !newName.isEmpty()) {
                existingLink.setLinkName(newName);
            }

            if (newUrl != null && !newUrl.isEmpty()) {
                existingLink.setLink(newUrl);
            }

            if (newDescription != null && !newDescription.isEmpty()) {
                existingLink.setDescription(newDescription);
            }

            linkHelper.updateLinkInformation(existingLink);
        }

        AssessmentHelper assessmentHelper = new AssessmentHelper();
        int assessmentId = selectedId + 1;
        TableAssessments existingAssessment = AssessmentHelper.getAssessmentById(assessmentId);

        if (existingAssessment != null) {
            String newThreatAssessment = request.getParameter("newThreatAssessment");
            String newSeverity = request.getParameter("newSeverity");

            if (newThreatAssessment != null && !newThreatAssessment.isEmpty()) {
                existingAssessment.setAssessment(newThreatAssessment);
            }

            if (newSeverity != null && !newSeverity.isEmpty()) {
                existingAssessment.setSeverity(newSeverity);
            }

            AssessmentHelper.updateAssessmentInformation(existingAssessment);
        }
        
        LinkAndAssessHelper linkAndAssessHelper = new LinkAndAssessHelper();
        linkAndAssessHelper.fetchAndInsertData();

        response.sendRedirect("index.html");
    }
}





