package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ex8 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ArrayList<Produto> produtos = new ArrayList<>();

    class Produto {
        String nome;
        double preco;

        Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String toString() {
            return nome + " - R$ " + preco;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Produtos Cadastrados:</h2>");
        out.println("<ul>");
        for (Produto produto : produtos) {
            out.println("<li>" + produto.toString() + "</li>");
        }
        out.println("</ul>");
        out.println("<p><a href=\"form08.html\">Cadastrar novo produto</a></p>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String precoStr = request.getParameter("preco");

        if (nome != null && !nome.trim().isEmpty() && precoStr != null && !precoStr.trim().isEmpty()) {
            double preco = Double.parseDouble(precoStr);
           
            produtos.add(new Produto(nome, preco));
        }

        doGet(request, response);
    }
}