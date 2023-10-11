package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TableAssessments;
import model.TableLinks;

@WebServlet("/AddLinkServlet")
public class AddLinkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddLinkServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String url = request.getParameter("URL");
        String description = request.getParameter("description");
        String threatAssessment = request.getParameter("threatAssessment");
        String severity = request.getParameter("severity");

        LocalDateTime currentTime = LocalDateTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeAdded = currentTime.format(formatter);

        TableLinks link = new TableLinks(name, url, description, timeAdded);
        TableAssessments assessment = new TableAssessments(threatAssessment, severity);

        LinkHelper linkHelper = new LinkHelper();
        linkHelper.insertLinkInformation(link);

        AssessmentHelper assessmentHelper = new AssessmentHelper();
        assessmentHelper.insertAssessmentInformation(assessment);
        
        LinkAndAssessHelper linkAndAssessHelper = new LinkAndAssessHelper();
        linkAndAssessHelper.fetchAndInsertData();

        response.sendRedirect("index.html");
    }
}

