package tads.dsw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exercicio4_2Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");

        // Cria um cookie e define o tempo de expiração para 1 dia
        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(24 * 60 * 60); // 1 dia
        response.addCookie(userCookie);

        response.sendRedirect("Exercicio4_2RemoveCookie");
	}

}
