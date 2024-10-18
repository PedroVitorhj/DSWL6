package tads.dsw;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exercicio2_1Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String par1 = request.getParameter("idade");

        // Adiciona um atributo à requisição para ser lido no próximo servlet
        request.setAttribute("idadeUsuario", "Você tem " + par1 + " anos!");

        // Despacha a requisição para o ProcessServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("Exercicio2_1Process");
        dispatcher.forward(request, response);
    }

}
