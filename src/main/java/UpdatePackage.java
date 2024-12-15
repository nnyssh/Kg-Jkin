import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatePackage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Retrieve input from HTML
           int  packageid = Integer.parseInt(request.getParameter("id"));
            String packageName = request.getParameter("packageName");
            Double price = Double.parseDouble(request.getParameter("price"));
            String duration = request.getParameter("duration");
            String additionalDetails = request.getParameter("additionalDetails");

            // Database connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection("jdbc:sqlserver://kgjkin.database.windows.net");

            // Update query
            String query = "UPDATE package SET packagename=?, packageprice=?, packageduration=?, packagedetails=? WHERE packageid=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, packageName);
            ps.setDouble(2, price);
            ps.setString(3, duration);
            ps.setString(4, additionalDetails);
            ps.setInt(5, packageid);
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("commit");
            
            int rowsUpdated = ps.executeUpdate();
            con.close();

            if (rowsUpdated > 0) {
                request.setAttribute("message", "Package updated successfully!");
            } else {
                request.setAttribute("message", "Failed to update package. Package ID not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while updating the package.");
        }

        // Forward back to the JSP
        RequestDispatcher req = request.getRequestDispatcher("ListPackage.jsp");
        req.forward(request, response);
    }
}