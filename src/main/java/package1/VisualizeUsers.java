package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet(urlPatterns = "/visualize")
public class VisualizeUsers extends HttpServlet {
       
   
    public VisualizeUsers() {
        super();
    }
    
    private static final long serialVersionUID = 1L;
	private Connection connection;

	private final String DB_URL = "jdbc:mysql://localhost:3306/Progetto_Modulo_2";

	private final String USER = "root";
	
	private final String PASS = "";
	
	public void init(ServletConfig config) {
		try {
			ServletContext context = config.getServletContext();

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
						
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Credenziali");
			PrintWriter out=response.getWriter();
			while(result.next()) {
				out.print(result);
			}
			/*if (result > 0) {
				out.print("<H1>HAI CREATO UN NUOVO UTENTE</H1>"); 
			} else {
				out.print("<H1>ERRORE NELLA CREAZIONE</H1>");
			}
			request.getRequestDispatcher("profilo.html").include(request, response);*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
