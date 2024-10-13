package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ex4 extends HttpServlet {
	private int contador = 0;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    contador++;
	    
	    response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<p>Esse servidor foi acessado: " + contador + " vezes</p>");
	    
	}

}
