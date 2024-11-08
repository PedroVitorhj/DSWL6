package src.main.controller;

import src.main.dao.NotaDAO;
import src.main.dto.NotaDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/NotaController")
public class NotaController extends HttpServlet {

    private NotaDAO notaDAO;

    @Override
    public void init() {
        notaDAO = new NotaDAO();
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
                insertNota(request, response);
                break;
            case "delete":
                deleteNota(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateNota(request, response);
                break;
            case "boletim":
            	processRequest(request, response);
                break;
            default:
                listNotas(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
    private void listNotas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int alunoId = Integer.parseInt(request.getParameter("alunoId"));
        List<NotaDTO> notas = notaDAO.listarNotasPorAluno(alunoId);
        request.setAttribute("notas", notas);
        request.setAttribute("alunoId", alunoId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nota-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int alunoId = Integer.parseInt(request.getParameter("alunoId"));
    	request.setAttribute("alunoId", alunoId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nota-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertNota(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	
        int alunoId = Integer.parseInt(request.getParameter("alunoId"));
        String disciplina = request.getParameter("disciplina");
        double nota = Double.parseDouble(request.getParameter("valor"));

        NotaDTO novaNota = new NotaDTO();
        novaNota.setAlunoId(alunoId);
        novaNota.setDisciplina(disciplina);
        novaNota.setNota(nota);
        
        notaDAO.inserirNota(novaNota);
        response.sendRedirect("NotaController?action=list&alunoId=" + alunoId);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int alunoId = Integer.parseInt(request.getParameter("alunoId"));
        NotaDTO nota = notaDAO.NotaParaEditar(id).stream()
                                .filter(n -> n.getId() == id)
                                .findFirst()
                                .orElse(null);
        
        request.setAttribute("nota", nota);
        request.setAttribute("alunoId", alunoId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nota-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateNota(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	
        int id = Integer.parseInt(request.getParameter("id"));
        int alunoId = Integer.parseInt(request.getParameter("alunoId"));
        String disciplina = request.getParameter("disciplina");
        double nota = Double.parseDouble(request.getParameter("valor"));

        NotaDTO atualizadaNota = new NotaDTO(id, alunoId, disciplina, nota);
        notaDAO.atualizarNota(atualizadaNota);
        response.sendRedirect("NotaController?action=list&alunoId=" + alunoId);
    }

    private void deleteNota(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int alunoId = Integer.parseInt(request.getParameter("alunoId"));
        notaDAO.excluirNota(id);
        response.sendRedirect("NotaController?action=list&alunoId=" + alunoId);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int alunoId = Integer.parseInt(request.getParameter("id"));
        
        Map<String, Double> boletim = notaDAO.calcularBoletimPorAluno(alunoId);

        request.setAttribute("boletim", boletim);
        request.getRequestDispatcher("boletim.jsp").forward(request, response);
    }
    
}