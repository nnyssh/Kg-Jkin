<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Package - Kg Jkin</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="background">
    <div class="overlay">
      <div class="content">
        <h2>Update New Package</h2>
        <form id="UpdatePackageForm" action="UpdatePackage" method="post">
        <%
        	int packageid = Integer.parseInt(request.getParameter("id"));
        %>
        <input type="hidden" name="packageid" value="<%= packageid %>">
          <label for="packageName" class="label">New Package Name</label>
          <input type="text" id="packageName" name="packageName" class="input" required>
          
          <label for="price" class="label">New Price</label>
          <input type="number" id="price" name="price" class="input" step="0.01" required>
          
          <label for="duration" class="label">New Duration</label>
          <input type="text" id="duration" name="duration" class="input" required>
          
          <label for="additionalDetails" class="label">New Additional Details</label>
          <input type="text" id="additionalDetails" name="additionalDetails" class="input" required>
          
          <button type="submit" class="button">Update Package</button>
        </form>
      </div>
    </div>

    <!-- Navigation Bar -->
    <nav>
        <div class="logo">
            <a href="index.html">Kg Jkin</a>
        </div>
    </nav>
</div>

</body>
</html>
