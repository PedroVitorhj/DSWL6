package tads.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exercicio4_1WelcomeCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
        String username = null;

        // Percorre os cookies para encontrar o cookie de nome "username"
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (username != null) {
            out.println("<h1>Welcome back, " + username + "!</h1>");
        } else {
            out.println("<h1>User not found!</h1>");
        }
	}

}
