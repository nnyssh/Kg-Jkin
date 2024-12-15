<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Package - Kg Jkin</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="background">
    <div class="overlay">
        <div class="content">
            <h2 style="text-align: center;">Package List</h2>

            <div class="package-list">
                <%
                    try {
                        // Establish database connection
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ZOOTOPIA", "system");
                        
                        // Prepare SQL query to fetch all packages
                        String sql = "SELECT * FROM package ORDER BY packageid";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        
                        // Iterate through result set and display package details 
                        while (rs.next()) {
                            int packageid = rs.getInt(1);
                            String name = rs.getString(2);
                            double price = rs.getDouble(3);
                    
                %>
                            <div class="package">
                                <p><strong>Id:</strong> <%= packageid %></p>
                                <p><strong>Name:</strong> <%= name %></p>
                                <p><strong>Price:</strong> RM <%= String.format("%.2f", price) %></p>
                                <p>
                                    <button onclick="ViewPackage(<%= packageid %>)">View</button>
                                </p>
                            </div>
                <%
                        }
                        // Close the database connection
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("<p>Error loading package list.</p>");
                    }
                %>
            </div>
        </div>
    </div>

    <!-- Navigation Bar with Home Button -->
    <nav>
        <div class="logo">
            <a href="index.html">Kg Jkin</a>
        </div>
    </nav>

</div>

<script type="text/javascript">
    function ViewPackage(id) {
        window.location.href = "ViewPackage.jsp?id=" + id;
    }
</script>

</body>
</html>
