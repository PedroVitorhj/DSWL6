package tads.dsw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Exercicio4_2RemoveCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Cookie[] cookies = request.getCookies();

        // Percorre os cookies para encontrar o cookie de nome "username"
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    // Define o tempo de vida do cookie para 0, removendo-o
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        response.setContentType("text/html");
        response.getWriter().println("<h1>Cookie removido com sucesso!<h1>");
    }
	
}
