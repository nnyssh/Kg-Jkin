<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Package - Kg Jkin</title>
<link rel="stylesheet" href="styles.css">

</head>
<body>

<div class="background">
    <!-- Navigation Bar with Home Button -->
    <nav>
        <div class="logo">
            <a href="index.html">Kg Jkin</a>
        </div>
    </nav>

    <div class="overlay">
        <div class="content">
            <h2>Package Info</h2>
            <%
            int packageid = Integer.parseInt(request.getParameter("id"));
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ZOOTOPIA", "system");
                
                String sql = "SELECT * FROM package WHERE packageid = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, packageid);
                
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
            %>
            <!-- Package Info Container -->
            <div class="package-container">
                <div class="package-detail">
                    <span class="label">Id:</span>
                    <span class="value"><%= rs.getInt(1) %></span>
                </div>
                <div class="package-detail">
                    <span class="label">Name:</span>
                    <span class="value"><%= rs.getString(2) %></span>
                </div>
                <div class="package-detail">
                    <span class="label">Price:</span>
                    <span class="value"><%= rs.getDouble(3) %></span>
                </div>
                <div class="package-detail">
                    <span class="label">Duration:</span>
                    <span class="value"><%= rs.getString(4) %></span>
                </div>
                <div class="package-detail">
                    <span class="label">Additional Details:</span>
                    <span class="value"><%= rs.getString(5) %></span>
                </div>
                
                <!-- Package Actions -->
                <div class="package-actions">
                    <button onclick="UpdatePackage(<%= packageid %>)">Update</button>
                    <button onclick="DeletePackage(<%= packageid %>)">Delete</button>
                </div>
            </div>
            <%
                } else {
                    out.println("<p>No package found with the given ID.</p>");
                }
                con.close();
            } catch (Exception e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }
            %>
        </div>
    </div>
</div>

<script type="text/javascript">
    function UpdatePackage(id) {
        window.location.href = "UpdatePackage.jsp?id=" + id;
    }
    function DeletePackage(id) {
        window.location.href = "DeletePackage?id=" + id;
    }
</script>

</body>
</html>
