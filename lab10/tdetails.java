package details;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
/**
 * Servlet implementation class tdetails
 */
public class tdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String[] accessories = request.getParameterValues("accessory");
        String tagline = request.getParameter("tagline");
        String pocket = request.getParameter("pocket");
        String color = request.getParameter("color");
        
        String accessoryList = "";
        if (accessories != null) {
            for (String accessory : accessories) {
                accessoryList += accessory + " ";
            }
        }

        try {
            // Load the MySQL JDBC driver
        	
        	int i=1;
            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teeshirt", "root", "Keerthan@11");

            // Insert the T-Shirt details into the database
            PreparedStatement ps = con.prepareStatement("INSERT INTO TShirts (OrderNo,Accessories, Tagline, Pocket, Color) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1,i);
            ps.setString(2, accessoryList.trim());
            ps.setString(3, tagline);
            ps.setString(4, pocket);
            ps.setString(5, color);
            ps.executeUpdate();

            // Retrieve and display all T-Shirt orders
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TShirts");
            out.println("<h2>All T-Shirts Orders</h2>");
            out.println("<table border='1'><tr><th>OrderNo</th><th>Accessories</th><th>Tagline</th><th>Pocket</th><th>Color</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("OrderNo") + "</td><td>" + rs.getString("Accessories") + "</td><td>" + rs.getString("Tagline") + "</td><td>" + rs.getString("Pocket") + "</td><td>" + rs.getString("Color") + "</td></tr>");
            }
            out.println("</table>");

            // Close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
	}

}
