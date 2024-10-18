package tads.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exercicio2_2Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String idade = (String) request.getAttribute("idadeUsuario");
	        
	        // Exibe a mensagem passada pelo MainServlet
	        out.println("<h1>" + idade + "</h1>");
	    }
}

