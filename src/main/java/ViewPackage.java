

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

/**
 * Servlet implementation class ViewPackage
 */
public class ViewPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	int packageid;
	String packageName, duration, additionalDetails;
	double price;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPackage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		packageid = Integer.parseInt(request.getParameter("id"));
		
		try {
			//call getConnection() method
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection("jdbc:sqlserver://kgjkin.database.windows.net");
			
			
			//3. create statement 
			ps = con.prepareStatement("SELECT * FROM package WHERE id=?");
			ps.setInt(1, packageid);
			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
			packageid = rs.getInt("packageid");
			packageName = rs.getString("packageName");
			price = rs.getDouble("price");
			duration = rs.getString("duration");
			additionalDetails = rs.getString("additional Details");
			
			}
			
			con.close();
		}catch(Exception e) {
		e.printStackTrace();
		}
		
		request.setAttribute("packageid", packageid);
		request.setAttribute("packageName", packageName);
		request.setAttribute("price", price);
		request.setAttribute("duration", duration);
		request.setAttribute("additionalDetails", additionalDetails);
		
		RequestDispatcher req = request.getRequestDispatcher("ViewPackage.jsp");
		req.forward(request, response); 

	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
