

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class AddPackage
 */
public class AddPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPackage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name = request.getParameter("packageName");
		double price = Double.parseDouble(request.getParameter("price"));
		String duration = request.getParameter("duration");
		String details = request.getParameter("additionalDetails");
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection("jdbc:sqlserver://kgjkin.database.windows.net");
			
			String sql = "INSERT INTO package(packageid, packagename, packageprice, packageduration, packagedetails) VALUES(product_id_seq.NEXTVAL,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setString(3, duration);
			ps.setString(4, details);
			
			ps.executeUpdate();
			con.close();
		}
		catch (Exception e){
			System.out.println(e);
			System.out.println("Error:" + e.getMessage());
		}
		
		RequestDispatcher req = request.getRequestDispatcher("index.html");
		req.forward(request, response);
	}
		
	}
