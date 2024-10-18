package tads.dsw;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Exercicio3_1Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        // Cria uma nova sessão para o usuário
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        // Redireciona para o dashboard
        response.sendRedirect("Exercicio3_1Dashboard");
    }

}
