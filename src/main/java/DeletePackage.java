

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
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class DeletePackage
 */
public class DeletePackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null;
	static PreparedStatement ps = null;
	//static Statement stmt = null;
	//static ResultSet rs = null;
	int packageid;
	//String packageName, duration, additionalDetails;
	//double price;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePackage() {
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
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection("jdbc:sqlserver://kgjkin.database.windows.net");
			
			String sql = "DELETE FROM package WHERE packageid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, packageid);
			ps.executeUpdate();
			
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			}

		RequestDispatcher req = request.getRequestDispatcher("index.html");
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
