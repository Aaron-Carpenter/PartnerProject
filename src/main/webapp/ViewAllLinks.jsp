<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Links and Assessments</title>
</head>
<body>
    <h1>View All Links and Assessments</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Link Name</th>
            <th>Link</th>
            <th>Time</th>
            <th>Description</th>
            <th>Assessment</th>
            <th>Severity</th>
        </tr>
        <c:forEach items="${allLinkAndAssess}" var="linkAndAssess">
            <tr>
                <td>${linkAndAssess.id}</td>
                <td>${linkAndAssess.linkName}</td>
                <td>${linkAndAssess.link}</td>
                <td>${linkAndAssess.time}</td>
                <td>${linkAndAssess.description}</td>
                <td>${linkAndAssess.assessment}</td>
                <td>${linkAndAssess.severity}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.html">Return to Index</a>
</body>
</html>

