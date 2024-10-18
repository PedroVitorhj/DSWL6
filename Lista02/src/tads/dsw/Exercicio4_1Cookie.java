package tads.dsw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exercicio4_1Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");

        // Cria um cookie e define o tempo de expiração para 1 hora
        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(60 * 60); // 1 hora
        response.addCookie(userCookie);

        response.sendRedirect("Exercicio4_1WelcomeCookie");
	}

}
