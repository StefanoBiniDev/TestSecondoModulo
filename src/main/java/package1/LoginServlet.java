package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(urlPatterns="/login")

public class LoginServlet extends HttpServlet {

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("userName");
		String password = request.getParameter("password");

		if (password.equals("admin")) {
			out.print("Welcome, " + name);
			HttpSession session = request.getSession();
			request.getRequestDispatcher("profilo.html").include(request, response);
			session.setAttribute("userName", name);
		} else {
			out.print("Mi dispiace, ma la password non è corretta");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}

}
