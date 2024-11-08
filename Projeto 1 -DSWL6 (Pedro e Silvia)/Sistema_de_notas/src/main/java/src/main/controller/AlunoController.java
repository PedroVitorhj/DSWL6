package src.main.controller;


import src.main.dao.AlunoDAO;
import src.main.dto.AlunoDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet {

    private AlunoDAO alunoDAO;

    @Override
    public void init() {
        alunoDAO = new AlunoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) action = "list";
        
        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertAluno(request, response);
                break;
            case "delete":
                deleteAluno(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateAluno(request, response);
                break;
            case "listSimple":
            	listAlunosSimples(request, response);
                break;
            default:
                listAlunos(request, response);
                break;
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

    private void listAlunos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<AlunoDTO> alunos = alunoDAO.listarAlunos();
        request.setAttribute("alunos", alunos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listAlunosSimples(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<AlunoDTO> alunos = alunoDAO.listarAlunos();
        request.setAttribute("alunos", alunos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-list-boletim.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertAluno(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        Date dataNascimento = parseDate(request.getParameter("dataNascimento"));

        AlunoDTO aluno = new AlunoDTO();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setDataNascimento(dataNascimento);

        alunoDAO.inserirAluno(aluno);
        response.sendRedirect("AlunoController?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AlunoDTO aluno = alunoDAO.listarAlunos().stream()
                                 .filter(a -> a.getId() == id)
                                 .findFirst()
                                 .orElse(null);

        request.setAttribute("aluno", aluno);
        RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateAluno(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        Date dataNascimento = parseDate(request.getParameter("dataNascimento"));

        AlunoDTO aluno = new AlunoDTO(id, nome, email, dataNascimento);
        alunoDAO.atualizarAluno(aluno);
        response.sendRedirect("AlunoController?action=list");
    }

    private void deleteAluno(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        alunoDAO.excluirAluno(id);
        response.sendRedirect("AlunoController?action=list");
    }

    private Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}